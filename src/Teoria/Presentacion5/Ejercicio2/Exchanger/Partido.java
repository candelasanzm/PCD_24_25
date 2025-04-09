package Teoria.Presentacion5.Ejercicio2.Exchanger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Partido {
    public List<Integer> participantes = new ArrayList<>();
    private boolean partidoFinalizado = false;
    private final Exchanger<String> exchanger;

    public Partido() {
        this.exchanger = new Exchanger<>();
    }

    public synchronized void llegar(int id) throws Exception {
        participantes.add(id);
        System.out.println("Niño " + id + " se une al partido");
    }

    public void realizarSorteo(){
        System.out.println("Ya hay 11 niños. Realizando el sorteo...");
        Collections.shuffle(participantes);
        System.out.println("Árbitro: " +  participantes.get(0));
        System.out.println("Equipo A " + participantes.subList(1, 6));
        System.out.println("Equipo B " + participantes.subList(6, 11));
        System.out.println("Empieza el partido");
    }

    public void finalizarPartido(){
        try {
            exchanger.exchange("Final");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void esperarFinal(int id){
        try {
            String mensaje = exchanger.exchange(null);
            if("Final".equals(mensaje)){
                System.out.println("Niño " + id + " escucha que el partido ha terminado");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
