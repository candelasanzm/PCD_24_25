package Teoria.Presentacion5.Ejercicio3.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        final int totalCochesCarreras = 20;
        final int totalCochesSeguridad = 2;
        final int totalCoches = totalCochesCarreras + totalCochesSeguridad;

        Carrera carrera = new Carrera(totalCoches, totalCochesSeguridad);

        for (int i = 1; i <= totalCochesCarreras; i++) {
            new Coche(i, carrera, false).start(); // Crear hilos para coches de carreras
        }

        for (int i = totalCochesCarreras + 1; i <= totalCoches; i++) {
            new Coche(i, carrera, true).start(); // Crear hilos para coches de seguridad
        }
    }
}
