package Teoria.Presentacion4.Ejercicio6.Semaforos;

import java.util.concurrent.Semaphore;

public class Tienda {
    private Semaphore probadores = new Semaphore(4);
    private Semaphore caja = new Semaphore(1);

    public Tienda() {}

    public void entrarProbador(int id, int numPrendas){
        try {
            probadores.acquire();
            System.out.println("Cliente " + id + " entra al probador");
            for (int i = 0; i < numPrendas; i++) {
                Thread.sleep(2000);
            }
            System.out.println("Cliente " + id + " sale del probador");
        } catch (Exception e) {}
        finally {
            probadores.release();
        }
    }

    public void pagar(int id, int numPrendas) throws InterruptedException {
        try {
            caja.acquire();
            Thread.sleep(numPrendas * 1000);
            System.out.println("Cliente " + id + " paga " + numPrendas + " prendas");
        } catch (Exception e) {}
        finally {
            caja.release();
        }
    }
}
