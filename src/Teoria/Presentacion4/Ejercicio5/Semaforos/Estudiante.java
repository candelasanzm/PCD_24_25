package Teoria.Presentacion4.Ejercicio5.Semaforos;

import java.util.Random;

public class Estudiante extends Thread {
    private int id;
    private Urna urna;
    Random random = new Random();

    public Estudiante(int id, Urna urna) {
        this.id = id;
        this.urna = urna;
    }

    public void run() {
        int voto = random.nextInt(3) + 1;
        try {
            urna.votar(voto);
        } catch (Exception e) {}
    }
}
