package Teoria.Presentacion3.Parte1.Ejercicio3;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tienda {
    ArrayList<Lock> probadores = new ArrayList<>();
    Lock caja = new ReentrantLock();

    public Tienda(){
        for (int i = 0; i <= 4; i++){
            probadores.add(new ReentrantLock());
        }
    }

    private void esperar(int segundos){
        try{
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void probarRopa(int id, int prendas){
        try{
            for (int i = 0; i < probadores.size(); i++){
                try {
                    probadores.get(i).tryLock();
                    esperar(prendas * 2);
                } catch (Exception e){
                } finally {
                    probadores.get(i).unlock();
                }
            }
        } catch (Exception e){}
    }

    public void pagar(int prendas, int id){
        caja.lock();
        try {
            esperar(prendas);
        } catch (Exception e){
        } finally {
            caja.unlock();
        }
    }
}
