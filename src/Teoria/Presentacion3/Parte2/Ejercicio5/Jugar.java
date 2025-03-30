package Teoria.Presentacion3.Parte2.Ejercicio5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Jugar {
    private Lock columpio = new ReentrantLock();
    private Condition lleno = columpio.newCondition();
    private Condition espera = columpio.newCondition();
    private int ninios = 0;

    public Jugar(){}

    public void montar(int id){
        columpio.lock();
        try{
            while (ninios >= 2){
                lleno.await();
            }
            ninios ++;
            System.out.println("Niño " + id + " se monta en el columpio. Niños en el columpio: " + ninios);

            while (ninios < 2){
                System.out.println("Niño " + id + " espera a otro niño");
                espera.await();
            }

            espera.signal();

            System.out.println("Niño " + id + " juega en el columpio");
        } catch (Exception e){
        } finally {
            columpio.unlock();
        }
    }

    public void bajar(int id){
        columpio.lock();
        try {
            ninios--;
            System.out.println("Niño " + id + " se baja del columpio");

            if (ninios < 2){
                lleno.signalAll();
            }
        } catch (Exception e){}
        finally {
            columpio.unlock();
        }
    }
}
