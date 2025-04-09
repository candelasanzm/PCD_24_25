package Teoria.Presentacion4.Ejercicio8.Semaforos;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Jugar {
    private int ninios = 0;
    private Semaphore semaforo1 = new Semaphore(2);
    private Semaphore semaforo2 = new Semaphore(1);

    public Jugar(){}

    public void montar(int id) throws InterruptedException {
        semaforo1.acquire();
        System.out.println("Niño " + id + " sube al columpio");

        if(semaforo2.hasQueuedThreads()){
            semaforo2.release();
        } else {
            semaforo2.acquire();
        }

        System.out.println("Niño " + id + " se monta en el columpio con otro niño.");
        sleep(3000);
        semaforo1.release();
        System.out.println("Niño " + id + " juega en el columpio");
    }
}
