package Teoria.ExamenesAnteriores.Examen2.Examen201617.Ejercicio2.OtraForma;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Carrera {
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(22);
    private CountDownLatch vueltaReconocimiento = new CountDownLatch(2);
    private CountDownLatch carrera = new CountDownLatch(20);
    private CocheCarreras ganador;

    public void llegarCircuito(int id){
        try {
            System.out.println("Coche " + id + " ha llegado al circuito");
            cyclicBarrier.await();
        } catch (InterruptedException e){
            System.out.println("InterruptedException en la llegada del coche " + id + ": " + e.toString());
        } catch (BrokenBarrierException e){
            System.out.println("BrokenBarrierException en la llegada del coche " + id + ":  " + e.toString());
        }
    }

    public void reconocimiento(CocheSeguridad cocheSeguridad){
        Random random = new Random();
        System.out.println("Coche de Seguridad " + cocheSeguridad.getIdCocheSeguridad() + " inicia la vuelta de reconocimiento");
        try {
            Thread.sleep(20000 + random.nextInt(10000));
        } catch (InterruptedException e){
            System.out.println("InterruptedException en la vuelta de reconocimiento del coche " + cocheSeguridad.getIdCocheSeguridad() + ": " + e.toString());
        }
        System.out.println("Coche de Seguridad " + cocheSeguridad.getIdCocheSeguridad() + " completa la vuelta de reconocimiento");
        vueltaReconocimiento.countDown();
    }

    public void correrCarrera(CocheCarreras cocheCarreras){
        try {
            vueltaReconocimiento.await();
        } catch (InterruptedException e){
            System.out.println("InterruptedException en la espera de la vuelta de reconocimiento" + cocheCarreras.getIdCocheCarreras() + ": " + e.toString());
        }

        Random random = new Random();
        System.out.println("Coche de Carreras " + cocheCarreras.getIdCocheCarreras() + " inicia la carrera");

        try {
            Thread.sleep(20000 + random.nextInt(10000));
        } catch (InterruptedException e){
            System.out.println("InterruptedException en la carrera del coche " + cocheCarreras.getIdCocheCarreras() + ": " + e.toString());
        }

        synchronized (carrera){
            System.out.println("Coche de Carreras " + cocheCarreras.getIdCocheCarreras() + " ha terminado la carrera");
            carrera.countDown();
            if(carrera.getCount() == 19){
                System.out.println("Coche de carreras " + cocheCarreras.getIdCocheCarreras() + " gana la carrera");
                ganador = cocheCarreras;
            }
        }
    }

    public void vueltaFinalCocheSeguridad(CocheSeguridad cocheSeguridad){
        try {
            carrera.await();
        } catch (InterruptedException e){
            System.out.println("InterruptedException en la espera a la vuelta de final del coche " + cocheSeguridad.getIdCocheSeguridad() + ": " + e.toString());
        }
        System.out.println("El ganador es " + ganador.getIdCocheCarreras());
    }
}
