package Teoria.Presentacion6.Ejercicio4;

import java.util.concurrent.BlockingQueue;

public class Empaquetado implements Runnable {
    private final BlockingQueue<Integer> lingotesQueue;

    public Empaquetado(BlockingQueue<Integer> lingotesQueue) {
        this.lingotesQueue = lingotesQueue;
    }

    @Override
    public void run() {
        int idCubo = 1;
        try {
            while(!Thread.currentThread().isInterrupted()) {
                for (int i = 0; i < 9; i++){
                    lingotesQueue.take();
                }
                System.out.println("Generando cubo " + idCubo);
                Thread.sleep(12000);
                System.out.println("Cubo " + idCubo + " terminado");
                idCubo++;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
