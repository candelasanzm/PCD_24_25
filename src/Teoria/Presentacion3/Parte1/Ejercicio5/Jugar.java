package Teoria.Presentacion3.Parte1.Ejercicio5;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Jugar {
    Lock columpio = new ReentrantLock();

    private void esperar (int segundos){
        try{
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void jugar(){
        int tiempoDeJuego =  1 + (int)(Math.random() * 20);
        esperar(tiempoDeJuego);
    }

    public void intentarMontar(int id) {
        int tiempoEspera = 5 + (int) (Math.random() * 6);
        long tiempoLimite = new Date().getTime() + tiempoEspera;

        boolean montado = false;
        while (new Date().getTime() < tiempoLimite && !montado) {
            if (columpio.tryLock()) {
                try {
                    System.out.println("Niño ID: " + id + " ha montado en el columpio");
                    esperar(3);
                    montado = true;
                } finally {
                    columpio.unlock();
                }
                break;
            } else {
                esperar(1);
            }
        }
        if (!montado) {
            System.out.println("Niño ID: " + id + " no ha podido montar en el columpio");
        }
    }
}
