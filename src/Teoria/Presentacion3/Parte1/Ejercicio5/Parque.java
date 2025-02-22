package Teoria.Presentacion3.Parte1.Ejercicio5;

public class Parque {
    public static void main(String[] args) {
        Thread[] ninos = new Thread[20];
        for (int i = 0; i < ninos.length; i++) {
            ninos[i] = new Thread(new Ninio(i + 1));
            ninos[i].start();
        }

        for (int i = 0; i < ninos.length; i++) {
            try {
                ninos[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
