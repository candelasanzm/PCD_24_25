package Teoria.Presentacion5.Ejercicio4.Exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ThreadLocalRandom;

public class Urna {
    private int[] votosCandidatos;
    private Exchanger<int[]> exchanger;
    private int capacidadUrna;
    private int votosActuales;
    private boolean votacionTerminada;

    public Urna(int capacidadUrna){
        this.capacidadUrna = capacidadUrna;
        votosCandidatos = new int[3];
        this.votosActuales = 0;
        this.exchanger = new Exchanger<>();
        this.votacionTerminada = false;
    }

    public synchronized void votar(int estudianteId){
        try {
            int voto = ThreadLocalRandom.current().nextInt(0,3);
            System.out.println("Estudiante " + estudianteId + " vota por el candidato " + voto);

            votosCandidatos[voto]++;
            votosActuales++;

            if (votosActuales == capacidadUrna){
                System.out.println("--- Urna llena, esperando al árbitro para el recuento parcial ---");
                exchanger.exchange(votosCandidatos);
                votosActuales = 0;
            }
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void calcularGanador(){
        try{
            System.out.println("--- Finalizando la votación. Calculando el ganador ---");
            int ganador = 0;
            for (int i = 0; i < votosCandidatos.length; i++) {
                if(votosCandidatos[i] > votosCandidatos[ganador]){
                    ganador = i;
                }
            }
            System.out.println("El candidato ganador es el " + ganador + " con " + votosCandidatos[ganador] + " votos");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void realizarRecuentoParcial(){
        try {
            int[] votos = exchanger.exchange(null);
            System.out.println("Recuento parcial realizado por el árbitro");
            for (int i = 0; i < votos.length; i++) {
                System.out.println("Candidato " + i + ": " + votos[i] + " votos");
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void finalizarVotacion(){
        votacionTerminada = true;
    }

    public synchronized boolean isVotacionTerminada(){
        return votacionTerminada;
    }
}
