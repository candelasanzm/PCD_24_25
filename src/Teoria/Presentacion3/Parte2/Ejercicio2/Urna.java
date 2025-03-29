package Teoria.Presentacion3.Parte2.Ejercicio2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Urna {
    private Lock cerrojo = new ReentrantLock();
    private Condition finVotacion = cerrojo.newCondition();
    private int candidato1 = 0;
    private int candidato2 = 0;
    private int candidato3 = 0;
    private int total = 0;

    public Urna(){}

    public void votar (int voto){
        cerrojo.lock();
        try {
            switch (voto){
                case 1:
                    candidato1++;
                    break;
                case 2:
                    candidato2++;
                    break;
                case 3:
                    candidato3++;
                    break;
            }
            total++;
            if (total == 80){
                finVotacion.signal();
                mostrarResultado();
            }
        } catch (Exception e){}
        finally {
            cerrojo.unlock();
        }
    }

    public void mostrarResultado() throws InterruptedException {
        while (total < 80){
            finVotacion.await();
        }

        System.out.println("Recuento de votos");
        System.out.println("Candidato 1: " + candidato1);
        System.out.println("Candidato 2: " + candidato2);
        System.out.println("Candidato 3: " + candidato3);

        int ganador = Math.max(candidato1, Math.max(candidato2, candidato3));

        if (ganador == candidato1 && ganador == candidato3 || ganador == candidato2 && ganador == candidato1 || ganador == candidato3 && ganador == candidato2){
            System.out.println("Empate, hay que repetir la votación");
        } else if (ganador == candidato1){
            System.out.println("Ganador: Candidato 1");
        } else if (ganador == candidato2){
            System.out.println("Ganador: Candidato 2");
        } else {
            System.out.println("Ganador: Candidato 3");
        }
    }
}
