package Teoria.Presentacion3.Parte1.Ejercicio2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SistemaVotacion {
    private int votos1, votos2, votos3 = 0;
    private Lock cerrojo = new ReentrantLock();

    public SistemaVotacion() {}

    public void votar(int voto){
        cerrojo.lock();

        try {
            switch (voto){
                case 1:
                    votos1 ++;
                case 2:
                    votos2 ++;
                case 3:
                    votos3 ++;
            }
            if (votos1 + votos2 + votos3 == 80){
                resultado();
            }
        } catch (Exception e) {}
        finally {
            cerrojo.unlock();
        }
    }

    public void resultado(){
        System.out.println("Recuento de votos");
        System.out.println("Votos candidato 1: " + votos1);
        System.out.println("Votos candidato 2: " + votos2);
        System.out.println("Votos candidato 3: " + votos3);

        int ganador = Math.max(votos1, Math.max(votos2, votos3));

        if ((ganador == votos1 && ganador ==votos2 || ganador == votos1 && ganador == votos3 || ganador == votos2 && ganador == votos3)){
            System.out.println(("Empate"));
        } else if (ganador == votos1) {
            System.out.println("El ganador es el candidato 1");
        } else if (ganador == votos2) {
            System.out.println("El ganador es el candidato 2");
        } else if (ganador == votos3) {
            System.out.println("El ganador es el candidato 3");
        }
    }
}
