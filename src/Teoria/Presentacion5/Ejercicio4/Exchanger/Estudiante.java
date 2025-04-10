package Teoria.Presentacion5.Ejercicio4.Exchanger;

public class Estudiante extends Thread {
    private int id;
    private Urna urna;

    public Estudiante(int id, Urna urna) {
        this.id = id;
        this.urna = urna;
    }

    public void run() {
        urna.votar(id);
    }
}
