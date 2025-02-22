package Teoria.Presentacion3.Parte1.Ejercicio4;

public class EmpresaServicios {
    public static void main(String[] args) {
        Thread[] trabajadores = new Thread[50];
        for (int i = 0; i < trabajadores.length; i++) {
            trabajadores[i] = new Thread(new Trabajador(i + 1));
            trabajadores[i].start();
        }

        for (int i = 0; i < trabajadores.length; i++) {
            try {
                trabajadores[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
