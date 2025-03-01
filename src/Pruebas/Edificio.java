package Pruebas;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Edificio {
    Lock cajetin = new ReentrantLock();
    Lock maquinaCafe = new ReentrantLock();
    private int totalCafes = 0;
    private int num_trabajadores = 0;

    private void esperar(int segundos){
        try{
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void fichar (int id, boolean entra){
        cajetin.lock();
        try{
            if (entra){
                num_trabajadores++;
                System.out.println("Trabajador " + id + " ha entrado a la hora: " + new Date() + ". Total de trabajadores dentro: " + num_trabajadores);
                esperar(1);
            } else {
                num_trabajadores--;
                System.out.println("Trabajador " + id + " ha salido a la hora: " + new Date() + ". Total de trabajadores dentro: " + num_trabajadores);
                esperar(1);
            }
        } catch (Exception e){
        } finally {
            cajetin.unlock();
        }
    }

    public void prepararCafe(int id){
        maquinaCafe.lock();
        try{
            totalCafes ++;
            System.out.println("Trabajador " + id + " se ha preparado un cafe. Total de cafes preparados: " + totalCafes);
            esperar(5);
        } catch (Exception e) {
        } finally {
            maquinaCafe.unlock();
        }
    }

    public void trabajar(int id){
        int tiempoTrabajo = 1 + (int) (Math.random() * 2);
        System.out.println("El trabajador " + id + " está trabajando");
        esperar(tiempoTrabajo);
    }


}
