package Teoria.Presentacion3.Parte2.Ejercicio4.Forma1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tienda {
    private Lock cerrojoProbadores = new ReentrantLock();
    private Lock cerrojoCaja = new ReentrantLock();
    private boolean[] probadores = new boolean[4];
    private Condition probadoresDisponibles = cerrojoProbadores.newCondition();
    private Condition cajaDisponible = cerrojoCaja.newCondition();
    private boolean caja = true;

    public Tienda() {}

    public int entrarProbador(int id, int numPrendas){
        cerrojoProbadores.lock();
        try{
            while(true){
                for (int i = 0; i < probadores.length; i++){
                    if(!probadores[i]){
                        probadores[i] = true;
                        System.out.println("Cliente " + id + " entra en el probador " + (i + 1));
                        return i;
                    }
                }
                probadoresDisponibles.await();
            }
        } catch (Exception e) {
            return -1;
        } finally {
            cerrojoProbadores.unlock();
        }
    }

    public void salirProbador(int id, int probador){
        cerrojoProbadores.lock();
        try{
            probadores[probador] = false;
            System.out.println("Cliente " + id + " sale del probador " + (probador + 1));
            probadoresDisponibles.signal();
        } catch (Exception e) {
        } finally {
            cerrojoProbadores.unlock();
        }
    }

    public void pagar(int id, int numPrendas){
        cerrojoCaja.lock();
        try {
            while(!caja){
                cajaDisponible.await();
            }
            caja = false;
            System.out.println("Cliente " + id + " está pagando " + numPrendas + " prendas");
        } catch (Exception e) {
        } finally {
            cerrojoCaja.unlock();
        }
    }

    public void terminarPago(int id){
        cerrojoCaja.lock();
        try {
            caja = true;
            System.out.println("Cliente " + id + " ha terminado de pagar");
            cajaDisponible.signal();
        } catch (Exception e) {
        } finally {
            cerrojoCaja.unlock();
        }
    }
}
