package Teoria.ExamenesAnteriores.Examen2.Examen201617.Ejercicio2.OtraForma;

import java.util.Random;

public class CocheSeguridad extends Thread {
    private int id;
    private Carrera carrera;

    public CocheSeguridad(int id, Carrera carrera) {
        this.id = id;
        this.carrera = carrera;
    }

    public int getIdCocheSeguridad() {
        return id;
    }

    public void run(){
        System.out.println("Coche de seguridad " + id + " llega al circuito");
        Random random = new Random();

        try {
            Thread.sleep(4000 + random.nextInt(16000));
        } catch (InterruptedException e) {
            System.out.println("InterruptedException en la llegada del coche de seguridad " + id + ": " + e.toString());
        }

        carrera.llegarCircuito(id);
        carrera.reconocimiento(this);
        carrera.vueltaFinalCocheSeguridad(this);
    }
}
