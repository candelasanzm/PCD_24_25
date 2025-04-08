package Teoria.ExamenesAnteriores.Examen2.Examen201617.Ejercicio2;

public class CocheS extends Thread{
    private Carrera carrera;

    public CocheS(Carrera c){
        this.carrera = c;
    }

    public void run(){
        carrera.esperar();
        carrera.reconocimiento();
        carrera.vueltaFinal();
    }
}
