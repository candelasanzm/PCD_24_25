package Teoria.Presentacion6.Ejercicio4;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        int totalUnidadesCompresion = 500;

        ExecutorService compresoresPool = Executors.newFixedThreadPool(7);
        ExecutorService empaquetadoresPool = Executors.newFixedThreadPool(5);

        BlockingQueue<Integer> lingotesQueue = new LinkedBlockingQueue<>(totalUnidadesCompresion);

        for (int i = 1; i <= totalUnidadesCompresion; i++) {
            compresoresPool.submit(new Compresion(i, lingotesQueue));
        }

        empaquetadoresPool.submit(new Empaquetado(lingotesQueue));

        compresoresPool.shutdown();
        empaquetadoresPool.shutdown();

        try {
            if (!compresoresPool.awaitTermination(1, TimeUnit.HOURS)){
                compresoresPool.shutdownNow();
            }
            if (!empaquetadoresPool.awaitTermination(1, TimeUnit.HOURS)){
                empaquetadoresPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            compresoresPool.shutdownNow();
            empaquetadoresPool.shutdownNow();
        }
    }
}
