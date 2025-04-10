package Laboratorio.Sesion6.Ejercicio2;

import java.util.Random;
import java.util.concurrent.Callable;

public class TramitadorDocumento implements Callable<String> {
    private final int documentoId;

    public TramitadorDocumento(int documentoId) {
        this.documentoId = documentoId;
    }

    @Override
    public String call(){
        try{
            double tiempo = 1 + new Random().nextDouble();
            System.out.println("Tramitando documento " + documentoId + " (tiempo estimado: " + tiempo + " segundos)...");
            Thread.sleep((long) (tiempo * 1000));
            return String.format("Documento " + documentoId + " tramitado correctamente");
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            return String.format("Documento " + documentoId + " no pudo tramitarse(error)");
        }
    }
}
