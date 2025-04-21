package Teoria.ExamenesAnteriores.Examen2.Examen201617.Ejercicio2.Clase;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Carrera {
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(22);
    private CountDownLatch countDownLatchSeguridad = new CountDownLatch(2);
    private CountDownLatch countDownLatchCarreras = new CountDownLatch(20);

    public void llegarCircuito(){
        try {
            cyclicBarrier.await();
            Thread.sleep(4000 + (int)(Math.random() * 13000));
        } catch (InterruptedException e){
            System.out.println("InterruptedException en la llegada al circuito del coche ");
        } catch (BrokenBarrierException e){
            System.out.println("BrokenBarrierException en la llegada al circuito ");
        }
    }

    public void reconocimiento(){
        try {
            countDownLatchSeguridad.countDown();
            Thread.sleep((int) (Math.random() * 20000) + 10000);
        } catch (InterruptedException e){
            System.out.println("InterruptedException en el reconocimiento " + e.toString());
        }
    }

    public void arrancarCarrera(){
        try {
            countDownLatchSeguridad.await();
            Thread.sleep((int) (Math.random() * 120000));
        } catch (InterruptedException e){
            System.out.println("InterruptedException al arrancar la carrera " + e.toString());
        }
    }

    public void finalizarCarrera(){
        try {
            countDownLatchCarreras.await();
        } catch (InterruptedException e){
            System.out.println("InterruptedException al finalizar la carrera " + e.toString());
        }
    }

    public void vueltaFinal(){
        try {
            countDownLatchCarreras.countDown();
        } catch (Exception e){
            System.out.println("Exception al vueltaFinal " + e.toString());
        }
    }
}
