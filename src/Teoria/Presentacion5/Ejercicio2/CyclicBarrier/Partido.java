package Teoria.Presentacion5.Ejercicio2.CyclicBarrier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class Partido {
    public List<Integer> participantes = new ArrayList<>();
    private boolean partidoFinalizado = false;
    private final CyclicBarrier cyclicBarrier;

    public Partido() {
        this.cyclicBarrier = new CyclicBarrier(11, () -> {
            System.out.println("Ya hay 11 niños. Realizando el sorteo...");
            Collections.shuffle(participantes);
            System.out.println("Árbitro: " +  participantes.get(0));
            System.out.println("Equipo A " + participantes.subList(1, 6));
            System.out.println("Equipo B " + participantes.subList(6, 11));
            System.out.println("Empieza el partido");
        });
    }

    public synchronized void llegar(int id) throws Exception {
        participantes.add(id);
        System.out.println("Niño " + id + " se une al partido");
        cyclicBarrier.await();
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
