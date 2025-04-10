package Laboratorio.Sesion6.Ejercicio1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TramitadorDocumentos {
    private final int totalDocumentos;
    private final int maxTramitadores;

    public TramitadorDocumentos(int totalDocumentos, int maxTramitadores) {
        this.totalDocumentos = totalDocumentos;
        this.maxTramitadores = maxTramitadores;
    }

    public void procesarDocumentos() {
        ExecutorService pool = Executors.newFixedThreadPool(maxTramitadores);

        for (int i = 1; i <= totalDocumentos; i++) {
            int documentoId = i;
            pool.submit(() -> {
                try{
                    double tiempo = 1 + Math.random();
                    System.out.println("Tramitando documento " + documentoId + " (tiempo estimado: " + tiempo + " segundos)...");
                    Thread.sleep((long) (tiempo * 1000));
                    System.out.println("Documento " + documentoId + " tramitado");
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        pool.shutdown();
        try {
            if(!pool.awaitTermination(1, TimeUnit.HOURS)){
                System.out.println("El pool no terminó a tiempo");
            }
        } catch (InterruptedException e){
            System.out.println("La espera fue interrumpida");
        }

        System.out.println("Todos los documentos han sido tramitados");
    }
}
