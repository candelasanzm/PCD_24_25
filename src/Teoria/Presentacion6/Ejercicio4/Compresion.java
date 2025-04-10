package Teoria.Presentacion6.Ejercicio4;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Compresion implements Runnable {
    private final int idUnidad;
    private final BlockingQueue<Integer> lingotesQueue;
    private final Random rand = new Random();

    public Compresion(int idUnidad, BlockingQueue<Integer> lingotesQueue) {
        this.idUnidad = idUnidad;
        this.lingotesQueue = lingotesQueue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (250 + rand.nextInt(501)));
            System.out.println("Unidad de compresión " + idUnidad + " ha llegado");
            Thread.sleep(3000);
            lingotesQueue.put(1);
            System.out.println("Unidad de compresión " + idUnidad + " generó un lingote");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
