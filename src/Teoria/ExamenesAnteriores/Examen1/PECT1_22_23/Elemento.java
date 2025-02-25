package Teoria.ExamenesAnteriores.Examen1.PECT1_22_23;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Elemento {
    private Lock cerrojo = new ReentrantLock();
    private String nombre = " ";
    private int numero = 0;

    public Elemento(String nombre) {
        this.nombre = nombre;
    }

    private void esperar(int segundos){
        try{
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void userElemento(int id, int dormir, boolean entra){
        cerrojo.lock();
        try{
            if (entra){
                numero ++;
                System.out.println("Usuario " + id + " usa " + nombre + " a las " + new Date() + " número de usos " + numero);
            } else {
                numero --;
                System.out.println("Usuario " + id + " sale de " + nombre + " a las " + new Date() );
            }
            esperar(dormir);
        } catch (Exception e){
        } finally {
            cerrojo.unlock();
        }
    }
}
