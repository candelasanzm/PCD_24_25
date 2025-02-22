package Teoria.Presentacion3.Parte1.Ejercicio5;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ninio implements Runnable{
    private int ninioId;
    static Lock columpio = new ReentrantLock();

    public Ninio(int id) {
        ninioId = id;
    }

    private void esperar (int segundos){
        try{
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private void jugar(){
        int tiempoDeJuego =  1 + (int)(Math.random() * 20);
        esperar(tiempoDeJuego);
    }

    private void intentarMontar(){
        int tiempoEspera = 5 + (int)(Math.random() * 6);
        long tiempoLimite = new Date().getTime() + (tiempoEspera * 1000);

        boolean montado = false;
        while (new Date().getTime() < tiempoLimite && !montado){
            if (columpio.tryLock()){
                try{
                    System.out.println("Niño ID: " + ninioId + " ha montado en el columpio");
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
        if (!montado){
            System.out.println("Niño ID: " + ninioId + " no ha podido montar en el columpio");
        }
    }

    public void run() {
        for (int i = 0; i < 30; i++) {
            jugar();
            intentarMontar();
        }
    }
}
