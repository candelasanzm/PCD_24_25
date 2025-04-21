package Teoria.ExamenesAnteriores.Examen2.Examen201617.Ejercicio1.OtraForma;

import java.util.Random;

public class Visitantes extends Thread {
    private int id;
    private Museo museo;

    public Visitantes(int id, Museo museo) {
        this.id = id;
        this.museo = museo;
    }

    public int getIdVisitante(){
        return this.id;
    }

    public void run(){
        try {
            Random random = new Random();

            if (random.nextDouble() < 0.5){
                museo.entrar_museo_este(this);
            } else {
                museo.entrar_museo_oeste(this);
            }
            Thread.sleep(500 + random.nextInt(1000));
            museo.salir_museo(this);
        } catch (Exception e) {}
    }
}
