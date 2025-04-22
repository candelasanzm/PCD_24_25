package Teoria.ExamenesAnteriores.Examen2.Examen202223.Ejercicio2;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cafeteria {
    private Semaphore puerta;
    private Semaphore aforo;
    private Semaphore barra;
    private Semaphore bancos;
    private Lock pago;
    private Condition pagoCondition;

    public Cafeteria() {
        puerta = new Semaphore(1);
        aforo = new Semaphore(50);
        barra = new Semaphore(15);
        bancos = new Semaphore(35);
        pago = new ReentrantLock();
        pagoCondition = pago.newCondition();
    }

    public void entrar(int id) throws InterruptedException {
        aforo.acquire();
        puerta.acquire();
        System.out.println("Cliente " + id + " entra a la cafetería");
        Thread.sleep(100);
        puerta.release();
    }

    public void salir(int id) throws InterruptedException {
        puerta.acquire();
        System.out.println("Cliente " + id + " sale de la cafetería");
        Thread.sleep(100);
        puerta.release();
        aforo.release();
    }

    public void elegirSitio(int id) throws InterruptedException {
        Random random = new Random();
        boolean quiereBarra = random.nextBoolean();
        if (quiereBarra) {
            if (!barra.tryAcquire()) {
                System.out.println("Cliente " + id + " espera en la cola de la barra");
                barra.acquire();
            }
            System.out.println("Cliente " + id + " ocupa un sitio en la barra");
        } else {
            if (!bancos.tryAcquire()) {
                System.out.println("Cliente " + id + " espera en la cola de los bancos");
                bancos.acquire();
            }
            System.out.println("Cliente " + id + " ocupa un sitio en los bancos");
        }
        Thread.sleep((int)(Math.random() * 11000) + 10000);
    }

    public void pagar(int id) throws InterruptedException {
        pago.lock();
        try {
            System.out.println("Cliente " + id + " está pagando");
            Thread.sleep(5000);
            pagoCondition.signal();
        } finally {
            pago.unlock();
        }
    }
}
