package Teoria.Presentacion3.Parte1.Ejercicio2;

public class Votaciones {
    public static void main(String[] args) {
        Thread[] hilos = new Thread[80];
        for (int i = 0; i < hilos.length; i++) {
            int estudianteID = i;
            hilos[i] = new Thread(() -> SistemaVotacion.votar(estudianteID));
            hilos[i].start();
        }

        for (int i = 0; i < hilos.length; i++) {
            try{
                hilos[i].join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        SistemaVotacion.anunciarGanador();
    }
}