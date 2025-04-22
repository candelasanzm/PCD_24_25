package Teoria.ExamenesAnteriores.Examen2.Examen202223.Ejercicio3;

import java.util.Random;

public class Estudiante extends Thread {
    private int[] respuestas;
    private Examen examen;

    public Estudiante (Examen examen){
        this.examen = examen;
    }

    public void run(){
        try {
            Random random = new Random();
            examen.esperarInicio();
            for (int i = 100; i < 200; i++){
                respuestas[i] = random.nextInt(100);
            }
            examen.entregarExamen(respuestas);
        } catch (Exception e) {}
    }
}
