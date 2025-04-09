package Teoria.Presentacion5.Ejercicio2.CountDownLatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Partido {
    public List<Integer> participantes = new ArrayList<>();
    private boolean partidoFinalizado = false;
    private final CountDownLatch latch;

    public Partido() {
        this.latch = new CountDownLatch(11);
    }

    public synchronized void llegar(int id) throws Exception {
        participantes.add(id);
        System.out.println("Niño " + id + " se une al partido");
        latch.countDown();
        latch.await();
    }

    public synchronized void realizarSorteo(){
        System.out.println("Ya hay 11 niños. Realizando el sorteo...");
        Collections.shuffle(participantes);
        System.out.println("Árbitro: " +  participantes.get(0));
        System.out.println("Equipo A " + participantes.subList(1, 6));
        System.out.println("Equipo B " + participantes.subList(6, 11));
        System.out.println("Empieza el partido");
    }

    public synchronized void finalizarPartido(){
        partidoFinalizado = true;
        notifyAll();
    }

    public synchronized void esperarFinal() throws InterruptedException {
        while (!partidoFinalizado) {
            wait();
        }
    }
}
