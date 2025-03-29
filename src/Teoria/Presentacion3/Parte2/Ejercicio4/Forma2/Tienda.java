package Teoria.Presentacion3.Parte2.Ejercicio4.Forma2;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tienda {
    private ArrayList<Lock> cerrojoProbadores = new ArrayList<>();
    private ArrayList<Condition> probadoresDisponibles = new ArrayList<>();
    private ArrayList<Boolean> estadoProbadores = new ArrayList<>();
    private Lock cerrojoCaja = new ReentrantLock();
    private Condition cajasDisponibles = cerrojoCaja.newCondition();
    private Boolean cajaOcupada = false;

    public Tienda(){
        for (int i = 0; i < 5; i++){
            Lock cerrojo = new ReentrantLock();
            cerrojoProbadores.add(cerrojo);
            probadoresDisponibles.add(cerrojo.newCondition());
            estadoProbadores.add(false);
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
        for (int i = 0; i < cerrojoProbadores.size(); i++){
            Lock cerrojo = cerrojoProbadores.get(i);
            Condition probadoresCondicion = probadoresDisponibles.get(i);

            cerrojo.lock();
            try {
                while (estadoProbadores.get(i)){
                    System.out.println("El cliente " + id + " está esperando para entrar al probador " + (i + 1));
                    probadoresCondicion.await(); // Esperar hasta que el probador esté disponible
                }

                // Una vez se accede al probador
                estadoProbadores.set(i, true);
                System.out.println("El cliente " + id + " ha accedido al probador " + (i + 1) + " con " + prendas + " prendas");
                esperar(prendas * 2);

                // Avisar de que el probador vuelve a estar libre
                estadoProbadores.set(i, false);
                System.out.println("El cliente " + id + " ha salido del probador " + (i + 1));
                probadoresCondicion.signal();
                break; // salir del bucle
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                cerrojo.unlock();
            }
        }
    }

    public void pagar(int id, int prendas){
        cerrojoCaja.lock();
        try {
            while(cajaOcupada){
                System.out.println("El cliente " + id + " está esperando para pagar");
                cajasDisponibles.await();
            }

            // Una vez se accede a la caja
            cajaOcupada = true;
            System.out.println("El cliente " + id + " está pagando " + prendas + " prendas");
            esperar(prendas);

            // Avisar de que la caja vuelve a estar disponible
            cajaOcupada = false;
            System.out.println("El cliente " + id + " ha terminado de pagar");
            cajasDisponibles.signal();
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        } finally {
            cerrojoCaja.unlock();
        }
    }
}
