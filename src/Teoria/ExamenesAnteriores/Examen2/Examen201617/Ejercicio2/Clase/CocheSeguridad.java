package Teoria.ExamenesAnteriores.Examen2.Examen201617.Ejercicio2.Clase;

public class CocheSeguridad extends Thread {
    private Carrera carrera;

    public CocheSeguridad(Carrera carrera) {
        this.carrera = carrera;
    }

    public void run(){
        carrera.llegarCircuito();
        carrera.reconocimiento();
        carrera.vueltaFinal();
    }
}
