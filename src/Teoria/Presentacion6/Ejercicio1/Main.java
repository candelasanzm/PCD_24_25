package Teoria.Presentacion6.Ejercicio1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int tamañoPool = 10;

        // Crear un pool de hilos
        ExecutorService executorService = Executors.newFixedThreadPool(tamañoPool);

        int limite = 10000000;
        int rango = 100000;

        for (int inicio = 1; inicio <= limite; inicio += rango) {
            int fin = Math.min(inicio + rango - 1, limite);

            Runnable tarea = new CalcularPrimos(inicio, fin);
            executorService.submit(tarea);
        }

        // Cerrar el pool de hilos
        executorService.shutdown();
    }
}
