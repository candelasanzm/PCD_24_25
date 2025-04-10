package Laboratorio.Sesion6.Ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        final int totalDocumentos = 600;
        final int maxTramitadores = 3;

        ExecutorService pool = Executors.newFixedThreadPool(maxTramitadores);

        List<Future<String>> futuros = new ArrayList<>();

        for (int i = 1; i <= totalDocumentos; i++) {
            TramitadorDocumento tarea = new TramitadorDocumento(i);
            Future<String> future = pool.submit(tarea);
            futuros.add(future);
        }

        for (Future<String> future : futuros) {
            try{
                String resultado = future.get();
                System.out.println(resultado);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error al obtener el resultado de una tarea");
            }
        }

        pool.shutdown();
        try {
            if (!pool.awaitTermination(1, TimeUnit.HOURS)){
                System.out.println("El pool no terminó a tiempo");
            }
        } catch (InterruptedException e) {
            System.out.println("La espera fue interrumpida");
        }

        System.out.println("Todos los documentos han sido procesados");
    }
}
