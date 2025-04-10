package Laboratorio.Sesion6.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        final int totalDocumentos = 600;
        final int maxTramitadores = 3;

        TramitadorDocumentos tramitadorDocumentos = new TramitadorDocumentos(totalDocumentos, maxTramitadores);
        tramitadorDocumentos.procesarDocumentos();
    }
}
