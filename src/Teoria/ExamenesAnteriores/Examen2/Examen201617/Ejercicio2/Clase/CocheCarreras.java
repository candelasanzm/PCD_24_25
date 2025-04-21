package Teoria.ExamenesAnteriores.Examen2.Examen201617.Ejercicio2.Clase;

public class CocheCarreras extends Thread {
    private Carrera carrera;

    public CocheCarreras(Carrera carrera) {
        this.carrera = carrera;
    }

    public void run() {
        try {
            carrera.llegarCircuito();
            carrera.arrancarCarrera();
            carrera.finalizarCarrera();
        } catch (Exception e){}
    }
}
