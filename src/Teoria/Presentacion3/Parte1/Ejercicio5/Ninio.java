package Teoria.Presentacion3.Parte1.Ejercicio5;

public class Ninio extends Thread{
    private int ninioId;
    Jugar j;

    public Ninio(int id, Jugar j) {
        this.ninioId = id;
        this.j = j;
    }

    public void run() {
        for (int i = 0; i < 30; i++) {
            j.jugar();
            j.intentarMontar(ninioId);
        }
    }
}
