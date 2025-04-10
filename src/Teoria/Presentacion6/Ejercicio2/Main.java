package Teoria.Presentacion6.Ejercicio2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
        int tamanoPool = 10;

        ExecutorService executorService = Executors.newFixedThreadPool(tamanoPool);

        int limite = 10000000;
        int rango = 100000;

        AtomicLong sumaTotal = new AtomicLong(0);

        for (int i = 1; i <= limite; i += rango) {
            int fin = Math.min(i + rango - 1, limite);

            Runnable tarea = new CalcularSuma(i, fin, sumaTotal);
            executorService.submit(tarea);
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.HOURS)) { // Esperamos que los hilos terminen
                executorService.shutdownNow(); // Forzamos el cierre si no terminan en tiempo
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
        System.out.println("Total suma: " + sumaTotal.get());
    }
}
