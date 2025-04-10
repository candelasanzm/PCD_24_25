package Teoria.Presentacion5.Ejercicio4.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class Urna {
    private int[] votos;
    private CyclicBarrier barrier;

    public Urna(int capacidadUrna, int totalEstudiantes){
        votos = new int[3];
        barrier = new CyclicBarrier(capacidadUrna, () -> {
            System.out.println("--- La urna está llena. Realizando recuento ---");
            recuentoParcial();
        });
    }

    public void votar(int estudianteId){
        try {
            int voto = ThreadLocalRandom.current().nextInt(0,3);
            votos[voto]++;
            System.out.println("Estudiante " + estudianteId + " vota por el candidato " + voto);
            barrier.await();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void mostrarGanador(){
        System.out.println("--- Finalizando la votación. Calculando el ganador ---");
        int ganador = 0;
        for (int i = 0; i < votos.length; i++) {
            if(votos[i] > votos[ganador]){
                ganador = i;
            }
        }
        System.out.println("El candidato ganador es el " + ganador + " con " + votos[ganador] + " votos");
    }

    private void recuentoParcial(){
        System.out.println("Recuento parcial realizado por el árbitro. Votos actuales: ");
        for (int i = 0; i < votos.length; i++) {
            System.out.println("Candidato " + i + ": " + votos[i] + " votos");
        }
    }
}
