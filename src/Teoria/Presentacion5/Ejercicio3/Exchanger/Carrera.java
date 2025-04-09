package Teoria.Presentacion5.Ejercicio3.Exchanger;

import java.util.concurrent.Exchanger;

public class Carrera {
    private final Exchanger<String> exchangerSeguridad;
    private final Exchanger<String> exchangerCarrera;

    public Carrera() {
        this.exchangerSeguridad = new Exchanger<>();
        this.exchangerCarrera = new Exchanger<>();
    }

    public void esperarRevisionSeguridad(int id){
        try {
            System.out.println("Coche de seguridad " + id + " inicia revisión del circuito.");
            Thread.sleep((long) (20000 + Math.random() * 10000)); // Simula revisión (20-30s)
            System.out.println("Coche de seguridad " + id + " termina revisión del circuito.");
            exchangerSeguridad.exchange("Revisión completada"); // Intercambio de datos con otro coche de seguridad
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void esperarInicioCarrera(int id) {
        try {
            String mensaje = exchangerSeguridad.exchange(null); // Los coches de carrera esperan señal de los coches de seguridad
            if ("Revisión completada".equals(mensaje)) {
                System.out.println("Coche de carreras " + id + " comienza la carrera.");
                Thread.sleep(120000); // Simula duración de la carrera (120s)
                System.out.println("Coche de carreras " + id + " termina la carrera.");
                exchangerCarrera.exchange("Carrera finalizada"); // Intercambio de datos indicando que un coche ha terminado
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void finalizarCarreraSeguridad(int id) {
        try {
            String mensaje = exchangerCarrera.exchange(null); // Los coches de seguridad esperan señal de los coches de carrera
            if ("Carrera finalizada".equals(mensaje)) {
                System.out.println("Coche de seguridad " + id + " indica el fin de la carrera.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}