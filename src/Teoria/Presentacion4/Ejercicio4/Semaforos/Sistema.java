package Teoria.Presentacion4.Ejercicio4.Semaforos;

import java.util.concurrent.Semaphore;

public class Sistema {
    private int max = 10;
    private int[] display = new int[max];
    private int count = 0;
    private int in = 0;
    private Semaphore em = new Semaphore(1);
    private Semaphore lleno = new Semaphore(10);
    private Semaphore datos = new Semaphore(0);

    public Sistema() {}

    public void escribir(int valor, int id) throws InterruptedException {
        lleno.acquire();
        em.acquire();
        display[in] = valor;
        in = (in + 1) % max;
        count++;
        System.out.println("Sensor " + id + " escribe valor " + valor);
        em.release();
        datos.release();
    }

    public void media() throws InterruptedException {
        for (int i = 0; i < 10; i++){
            datos.acquire();
        }
        em.acquire();
        int suma = 0;
        for (int i = 0; i < max; i++) {
            suma += display[i];
        }
        int media = suma / max;
        System.out.println("Temperatura media: " + media);
        count = 0;
        in = 0;
        em.release();
        lleno.release(10); // libera espacio
    }
}
