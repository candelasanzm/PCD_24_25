package Laboratorio.Sesion5.Ejercicio2;

import javax.swing.*;
import java.util.concurrent.Semaphore;

public class Exposicion {
    int aforo;
    ListaThreads colaEspera, dentro;
    Semaphore semaforo;
    boolean abierta = true;
    boolean detener = false;

    public Exposicion(int aforo, JTextField tfEsperan, JTextField tfDentro) {
        this.aforo=aforo;
        semaforo=new Semaphore(aforo,true); //El semáforo se crea como justo
        colaEspera=new ListaThreads(tfEsperan);
        dentro=new ListaThreads(tfDentro);
    }

    public void entrar(Visitante v) {
        if (!estaAbierta()){
            return;
        }

        colaEspera.meter(v);
        try {
            semaforo.acquire();
        } catch(InterruptedException e){ }
        colaEspera.sacar(v);
        dentro.meter(v);
    }

    public void salir(Visitante v) {
        dentro.sacar(v);
        semaforo.release();
    }

    public void mirar(Visitante v) {
        try {
            Thread.sleep(2000+(int)(3000*Math.random()));
        } catch (InterruptedException e){ }
    }

    public synchronized void abrir(){
        abierta = true;
    }

    public synchronized void cerrar(){
        abierta = false;
    }

    public synchronized boolean estaAbierta(){
        return abierta;
    }

    public synchronized void setDetener(boolean detener){
        this.detener = detener;
    }

    public synchronized boolean getDetener(){
        return detener;
    }
}
