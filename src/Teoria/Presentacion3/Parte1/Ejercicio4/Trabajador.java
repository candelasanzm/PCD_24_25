package Teoria.Presentacion3.Parte1.Ejercicio4;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Trabajador implements Runnable {
    private int trabajadorID;
    private static int totalCafes = 0;
    private static int numeroTrabajadores = 0;
    static Lock cajetin = new ReentrantLock();
    static Lock maquinaCafe = new ReentrantLock();

    public Trabajador(int id) {
        trabajadorID = id;
    }

    private void esperar(int segundos){
        try{
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void ficharEntrada(){
        cajetin.lock();
        try{
            numeroTrabajadores++;
            System.out.println("Trabajador ID: " + trabajadorID + ", Hora de entrada: " + new Date().getTime() + ". Trabajadores fichados: " + numeroTrabajadores);
        } finally {
            cajetin.unlock();
        }
        esperar(1);
    }

    private void prepararCafe(){
        maquinaCafe.lock();
        try {
            totalCafes++;
            System.out.println("Total de cafés preparados: " + totalCafes);
        } finally {
            maquinaCafe.unlock();
        }
        esperar(5);
    }

    private void trabajar(){
        int tiempoTrabajo = 2 + (int)(Math.random() * 1);
        esperar(tiempoTrabajo);
    }

    private void ficharSalida(){
        cajetin.lock();
        try{
            numeroTrabajadores--;
            System.out.println("Trabajador ID: " + trabajadorID + ", Hora de salida: " + new Date().getTime() + ". Trabajadores dentro: " + numeroTrabajadores);
        } finally {
            cajetin.unlock();
        }
    }

    public void run(){
        //Inicio jornada laboral
        ficharEntrada();

        //Preparar cafe
        prepararCafe();

        //Acudir a su mesa de trabajo
        trabajar();

        //Segundo cafe para ID par
        if (trabajadorID % 2 == 0){
            prepararCafe();
        }

        //Volver a trabajar
        trabajar();

        //Fichar salida
        ficharSalida();
    }
}
