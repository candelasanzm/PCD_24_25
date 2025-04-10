package Teoria.Presentacion5.Ejercicio4.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

public class Urna {
    private int[] votos;
    private CountDownLatch latchRecuento;
    private CountDownLatch latchFinVotacion;
    private int capacidadUrna;

    public Urna(int capacidadUrna, int totalEstudiantes){
        this.capacidadUrna = capacidadUrna;
        votos = new int[3];
        latchRecuento = new CountDownLatch(capacidadUrna);
        latchFinVotacion = new CountDownLatch(totalEstudiantes);
    }

    public void votar(int estudianteId){
        try {
            int voto = ThreadLocalRandom.current().nextInt(0,3);
            votos[voto]++;
            System.out.println("Estudiante " + estudianteId + " vota por el candidato " + voto);
            latchRecuento.countDown();
            latchFinVotacion.countDown();

            if (latchRecuento.getCount() == 0){
                recuentoParcial();
                latchRecuento = new CountDownLatch(capacidadUrna);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void mostrarGanador(){
        try{
            latchFinVotacion.await();
            System.out.println("--- Finalizando la votación. Calculando el ganador ---");
            int ganador = 0;
            for (int i = 0; i < votos.length; i++) {
                if(votos[i] > votos[ganador]){
                    ganador = i;
                }
            }
            System.out.println("El candidato ganador es el " + ganador + " con " + votos[ganador] + " votos");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void recuentoParcial(){
        System.out.println("Recuento parcial realizado por el árbitro. Votos actuales: ");
        for (int i = 0; i < votos.length; i++) {
            System.out.println("Candidato " + i + ": " + votos[i] + " votos");
        }
    }
}
