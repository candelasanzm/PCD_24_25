package Teoria.Presentacion3.Parte1.Ejercicio2;

public class Estudiante extends Thread {
    private SistemaVotacion urna;

    public Estudiante(SistemaVotacion urna) {
        this.urna = urna;
    }

    public void run(){
        int voto = 1 + (int)(Math.random() * 2);
        urna.votar(voto);
    }
}
