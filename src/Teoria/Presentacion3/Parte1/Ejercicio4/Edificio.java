package Teoria.Presentacion3.Parte1.Ejercicio4;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Edificio {
    private static int totalCafes = 0;
    private static int numeroTrabajadores = 0;
    Lock cajetin = new ReentrantLock();
    Lock maquinaCafe = new ReentrantLock();

    private void esperar(int segundos){
        try{
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void ficharEntrada(int iD){
        cajetin.lock();
        try{
            numeroTrabajadores++;
            System.out.println("Trabajador ID: " + iD + ", Hora de entrada: " + new Date() + ". Trabajadores fichados: " + numeroTrabajadores);
        } finally {
            cajetin.unlock();
        }
        esperar(1);
    }

    public void prepararCafe(){
        maquinaCafe.lock();
        try {
            totalCafes++;
            System.out.println("Total de cafés preparados: " + totalCafes);
        } finally {
            maquinaCafe.unlock();
        }
        esperar(5);
    }

    public void trabajar(int id){
        int tiempoTrabajo = 2 + (int)(Math.random() * 1);
        System.out.println("El trabajador id: " + id + " trabaja durante " + tiempoTrabajo + " segundos");
        esperar(tiempoTrabajo);
    }

    public void ficharSalida(int iD){
        cajetin.lock();
        try{
            numeroTrabajadores--;
            System.out.println("Trabajador ID: " + iD + ", Hora de salida: " + new Date() + ". Trabajadores dentro: " + numeroTrabajadores);
        } finally {
            cajetin.unlock();
        }
    }
}
