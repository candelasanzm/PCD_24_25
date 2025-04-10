package Laboratorio.Sesion6.Ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        final int limite = 10000000;
        final int numTareas = 5;
        final int tamanoPool = 3;

        ExecutorService pool = Executors.newFixedThreadPool(tamanoPool);
        List<Future<Long>> resultados = new ArrayList<>();
        int intervalo = limite / numTareas;

        for (int i = 0; i < numTareas; i++) {
            int inicio = i * intervalo + 1;
            int fin;
            if (i == numTareas - 1) {
                fin = limite;
            } else {
                fin = (i + 1) * intervalo;
            }
            CalculadorPrimos tareas = new CalculadorPrimos(inicio, fin);
            resultados.add(pool.submit(tareas));
        }

        long sumaTotal = 0;

        for (Future<Long> future : resultados) {
            try{
                sumaTotal += future.get();
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error al calcular una tarea " + e.getMessage());
            }
        }

        System.out.println("La suma de los números primos entre 1 y 10 millones es " + sumaTotal);

        pool.shutdown();
        try {
            if (!pool.awaitTermination(1, TimeUnit.HOURS)){
                System.out.println("El pool no terminó a tiempo");
            }
        } catch (InterruptedException e) {
            System.out.println("La espera fue interrumpida");
        }
    }
}
