package Teoria.Presentacion5.Ejercicio3.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Carrera {
    private final CountDownLatch llegadaLatch;
    private final CountDownLatch revisionLatch;
    private final CountDownLatch carreraLatch;

    public Carrera(int totalCoches, int cochesSeguridad) {
        llegadaLatch = new CountDownLatch(totalCoches);
        revisionLatch = new CountDownLatch(cochesSeguridad);
        carreraLatch = new CountDownLatch(totalCoches - cochesSeguridad);
    }

    public void esperarLlegada() {
        llegadaLatch.countDown();
        try {
            llegadaLatch.await(); // Espera a que lleguen todos los coches
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("--- Todos los coches han llegado al circuito ---");
    }

    public void iniciarRevision() {
        try {
            System.out.println("--- Los coches de seguridad están revisando el circuito ---");
            Thread.sleep((long) (20000 + Math.random() * 10000)); // Revisión tarda entre 20-30s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- Revisión del circuito completada ---");
        revisionLatch.countDown();
    }

    public void iniciarCarrera() {
        try {
            revisionLatch.await();
            System.out.println("--- La carrera ha comenzado ---");
            Thread.sleep(120000); // La carrera dura 120s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- La carrera ha terminado ---");
    }

    public void finalizarCarrera(){
        carreraLatch.countDown();
        try{
            carreraLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- La carrera ha terminado ---");
    }
}