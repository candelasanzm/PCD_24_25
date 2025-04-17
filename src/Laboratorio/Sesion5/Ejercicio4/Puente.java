package Laboratorio.Sesion5.Ejercicio4;

import javax.swing.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Thread.currentThread;

public class Puente {
    private Cola esperanID, esperanDI, dentro;
    private int cuenta = 0;
    private int esperandoIzqDch = 0, esperandoDchIzq = 0;
    private int pasandoIzqDch = 0, pasandoDchIzq = 0;
    private Semaphore dentroPuente = new Semaphore(8, true);
    private Lock lock = new ReentrantLock();
    private Condition izqDch = lock.newCondition();
    private Condition dchIzq = lock.newCondition();
    private Condition parado = lock.newCondition();
    private boolean parar = false;
    private JLabel sentido;

    public Puente(JTextField c1,JTextField c2,JTextField c3,JLabel l4) {
        esperanID = new Cola(c1);
        esperanDI = new Cola(c2);
        dentro = new Cola(c3);
        sentido=l4;
    }

    public void llegarPuente(int num) throws InterruptedException {
        lock.lock();
        try {
            switch (num % 2) {
                case 0: //Si es par, su sentido será izda -> dcha
                    esperanID.meter(currentThread());
                    esperandoIzqDch++;
                    while ((pasandoDchIzq != 0)||(cuenta >= 5)) {
                        izqDch.await();
                    }

                    esperanID.sacar(currentThread());
                    esperandoIzqDch--;
                    if(esperandoDchIzq > 0) {
                        cuenta++;
                    }
                    pasandoIzqDch++;
                    return;
                case 1: //Si es impar, su sentido será dcha -> izda
                    esperanDI.meter(currentThread());
                    esperandoDchIzq++;
                    while ((pasandoIzqDch != 0)||(cuenta >= 5)) {
                        dchIzq.await();
                    }

                    esperanDI.sacar(currentThread());
                    esperandoDchIzq--;
                    if(esperandoIzqDch > 0) {
                        cuenta++;
                    }
                    pasandoDchIzq++;
                    return;
            }
        }
        finally {
            lock.unlock();
        }
    }

    public void pasarPuente(int num) {
        lock.lock();
        try {
            try {
                dentroPuente.acquire(); //Ocupo un hueco en el puente
            } catch(InterruptedException e){}
            dentro.meter(currentThread());

            if(num % 2 == 0) {
                sentido.setText("Sentido: izquierda -> derecha");
                System.out.println("num1: "+num);
            }
            else {
                sentido.setText("Sentido: derecha -> izquierda");
                System.out.println("num2: "+num);
            }

            if (mirarSiParar()) {
                try {
                    parado.await();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Puente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void salirPuente(int num) {
        lock.lock();
        try {
            dentro.sacar(currentThread());
            dentroPuente.release(); //Libero un hueco en el puente
            switch (num % 2) {
                case 0: //Si el vehículo es par, pasaba de izda a dcha
                    pasandoIzqDch--;
                    if (pasandoIzqDch == 0) { //Si es el último
                        cuenta = 0; //Ponemos la cuenta a 0
                        dchIzq.signalAll(); //Y avisamos a los que quieren cruzar en el otro sentido
                    }
                    return;
                case 1: //Si el vehículo es impar, pasaba de dcha a izda
                    pasandoDchIzq--;
                    if (pasandoDchIzq == 0) { //Si es el último
                        cuenta = 0; //Ponemos la cuenta a 0
                        izqDch.signalAll(); //Y avisamos a los que quieren cruzar en el otro sentido
                    }
                    return;
            }
        } finally {
            lock.unlock();
        }
    }

    public void parar() {
        this.parar = true;
    }

    public boolean mirarSiParar() {
        return this.parar;
    }

    public void continuar() {
        lock.lock();
        try {
            this.parar = false;
            parado.signalAll();
        } finally {
            lock.unlock();
        }
    }
}