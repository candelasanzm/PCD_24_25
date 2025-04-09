package Teoria.Presentacion4.Ejercicio7.Semaforos;

import java.util.Date;
import java.util.concurrent.Semaphore;

public class Empresa {
    private int totalCafes = 0;
    private int numeroTrabajadores = 0;
    private Semaphore cafe = new Semaphore(1);
    private Semaphore fichar = new Semaphore(1);
    private Semaphore em = new Semaphore(1); // es necesario porque hay variables compartidas

    public Empresa() {}

    public synchronized void fichar(int iD, boolean entra){
        try{
            fichar.acquire();
            em.acquire();

            if(entra) {
                numeroTrabajadores++;
                System.out.println("Trabajador ID: " + iD + ", Hora de entrada: " + new Date() + ". Trabajadores fichados: " + numeroTrabajadores);
                Thread.sleep(1000);
            } else {
                numeroTrabajadores--;
                System.out.println("Trabajador ID: " + iD + ", Hora de salida: " + new Date() + ". Trabajadores dentro: " + numeroTrabajadores);
                Thread.sleep(1000);
            }
        } catch(Exception e){}
        finally {
            em.release();
            fichar.release();
        }
    }

    public synchronized void prepararCafe(){
        try {
            cafe.acquire();
            em.acquire();
            totalCafes++;
            System.out.println("Total de cafés preparados: " + totalCafes);
            Thread.sleep(5000);
        } catch (Exception e) {}
        finally {
            em.release();
            cafe.release();
        }
    }

    public void trabajar(int id){
        try{
            int tiempoTrabajo = 2 + (int)(Math.random() * 1);
            System.out.println("El trabajador id: " + id + " trabaja durante " + tiempoTrabajo + " segundos");
            Thread.sleep(tiempoTrabajo);
        } catch (Exception e) {}
    }
}
