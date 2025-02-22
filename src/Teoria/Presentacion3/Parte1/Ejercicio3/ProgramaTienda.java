package Teoria.Presentacion3.Parte1.Ejercicio3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProgramaTienda extends Thread{
    private int clienteID;
    private static int num_probadores = 4;
    private int prendas;
    static Lock[] probadores = new ReentrantLock[num_probadores];
    Lock caja = new ReentrantLock();

    static {
        for (int i = 0; i < num_probadores; i++){
            probadores[i] = new ReentrantLock();
        }
    }

    public ProgramaTienda(int id){
        this.clienteID = id;
        this.prendas = (int) (Math.random() * 5);
    }

    public void run(){
        if (prendas > 0){
            boolean probado = false;

            while(!probado){
                for (int i = 0; i < num_probadores; i++){
                    if (probadores[i].tryLock()){
                        try {
                            System.out.println("Cliente " + clienteID + " usa el probador numero " + i + " con " + prendas + " prendas");
                            try{
                                sleep(prendas * 2000);
                            } catch (InterruptedException e){
                                e.printStackTrace();
                            }
                            probado = true;
                        } finally {
                            probadores[i].unlock();
                        }
                        break;
                    }
                }
            }
        }

        boolean compraPrenda = Math.random() > 0.5;

        if (compraPrenda && prendas > 0){
            System.out.println("Cliente " + clienteID + " le ha gustado alguna prenda y va a caja a pagar");

            caja.lock();
            try {
                sleep(prendas * 1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                caja.unlock();
            }
        }

        System.out.println("El cliente " + clienteID + " ha abandonado la tienda");
    }
}
