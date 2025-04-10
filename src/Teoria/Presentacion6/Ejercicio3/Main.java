package Teoria.Presentacion6.Ejercicio3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int cajas = 2;

        ExecutorService executorService = Executors.newFixedThreadPool(cajas);

        int totalClientes = 20;

        for (int i = 1; i <= totalClientes; i++) {
            Runnable cliente = new Cliente(i);
            executorService.submit(cliente);
        }

        executorService.shutdown();
        try {
            if(!executorService.awaitTermination(1, TimeUnit.HOURS)){
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
