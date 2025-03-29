package Teoria.Presentacion3.Parte2.Ejercicio2;

import java.util.Random;

public class Estudiante extends Thread{
    private int id;
    private Urna urna;
    private Random random = new Random();

    public Estudiante(int id, Urna urna) {
        this.id = id;
        this.urna = urna;
    }

    public void run() {
        int voto = random.nextInt(3) + 1;
        urna.votar(voto);
    }
}
