package Teoria.Presentacion3.Parte1.Ejercicio2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SistemaVotacion {
    private static int[] candidatos = new int[3];
    static Lock lock = new ReentrantLock();

    public static void votar(int estudianteID){
        int candidato = (int) (Math.random() * 3);
        lock.lock();

        try {
            candidatos[candidato]++;
            System.out.println("Estudiante " + estudianteID + " votó al candidato: " + (candidato + 1) + ". Recuento actual: ");
            for (int i = 0; i < candidatos.length; i++) {
                System.out.println("Candidato " + (i + 1) + ": " + candidatos[i]);
            }
        } finally {
            lock.unlock();
        }
    }

    public static void anunciarGanador(){
        int ganador = 0;
        for (int i = 1; i < candidatos.length; i++) {
            if (candidatos[i] > candidatos[ganador]) {
                ganador = i;
            }
        }
        System.out.println("El candidato " + (ganador + 1) + "ha sido seleccionado como delegado");
    }
}
