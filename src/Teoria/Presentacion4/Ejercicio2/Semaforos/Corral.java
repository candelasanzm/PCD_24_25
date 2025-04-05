package Teoria.Presentacion4.Ejercicio2.Semaforos;

import java.util.concurrent.Semaphore;

public class Corral {
    Semaphore comedero = new Semaphore(4);
    Semaphore bebedero = new Semaphore(8);
    Semaphore camas = new Semaphore(10);

    public Corral(){}

    public void pasear(int id, boolean entra){
        if(entra) {
            System.out.println("Pollo " + id + " pasea");
        } else {
            System.out.println("Pollo " + id + " termina su paseo");
        }
    }

    public void comer(int id) {
        try {
            comedero.acquire();
            System.out.println("Pollo " + id + " come");
            Thread.sleep((int)(Math.random() * 5000) + 2000);
            System.out.println("Pollo " + id + " termina de comer");
        }catch(Exception e){}
        finally{
            comedero.release();
        }
    }

    public void beber(int id) {
        try {
            bebedero.acquire();
            System.out.println("Pollo " + id + " bebe");
            Thread.sleep((int)(Math.random() * 3000) + 1000);
            System.out.println("Pollo " + id + " termina de beber");
        }catch (Exception e){}
        finally{
            bebedero.release();
        }
    }

    public  void dormir(int id) {
        try{
            camas.acquire();
            System.out.println("Pollo " + id + " duerme");
            Thread.sleep((int)(Math.random() * 5000) + 15000);
            System.out.println("Pollo " + id + " se despierta");
        }catch(Exception e){}
        finally{
            camas.release();
        }
    }
}