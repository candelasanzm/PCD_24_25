package Teoria.Presentacion5.Ejercicio3.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class Carrera {
    private final CyclicBarrier barrier;
    private final int totalCoches; // Número total de coches en el circuito

    public Carrera(int totalCoches) {
        this.totalCoches = totalCoches;
        barrier = new CyclicBarrier(totalCoches, () -> {
            System.out.println("--- Todos los coches han llegado al circuito ---");
        });
    }

    public void esperarLlegada() {
        try {
            barrier.await(); // Espera a que lleguen todos los coches
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void iniciarRevision() {
        System.out.println("--- Los coches de seguridad están revisando el circuito ---");
        try {
            Thread.sleep((long) (20000 + Math.random() * 10000)); // Revisión tarda entre 20-30s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- Revisión del circuito completada ---");
    }

    public void iniciarCarrera() {
        System.out.println("--- La carrera ha comenzado ---");
        try {
            Thread.sleep(120000); // La carrera dura 120s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- La carrera ha terminado ---");
    }
}