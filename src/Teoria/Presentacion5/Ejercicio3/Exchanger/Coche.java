package Teoria.Presentacion5.Ejercicio3.Exchanger;

public class Coche extends Thread {
    private final int id;
    private final Carrera carrera;
    private final boolean esCocheSeguridad; // Identifica si es coche de seguridad

    public Coche(int id, Carrera carrera, boolean esCocheSeguridad) {
        this.id = id;
        this.carrera = carrera;
        this.esCocheSeguridad = esCocheSeguridad;
    }

    @Override
    public void run() {
        try {
            System.out.println("Coche " + id + (esCocheSeguridad ? " (seguridad)" : " (carrera)") + " llega al circuito");
            Thread.sleep((long) (4000 + Math.random() * 12000)); // Tiempo aleatorio entre 4-16s

            if (esCocheSeguridad) {
                carrera.esperarRevisionSeguridad(id);
                carrera.finalizarCarreraSeguridad(id);
            } else {
                carrera.esperarInicioCarrera(id);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
