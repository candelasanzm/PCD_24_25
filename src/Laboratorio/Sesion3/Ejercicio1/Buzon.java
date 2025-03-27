package Laboratorio.Sesion3.Ejercicio1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buzon {
    private String mensaje;
    private boolean hayMensaje = false;
    private Lock cerrojo = new ReentrantLock();
    private Condition mens = cerrojo.newCondition();
    private Condition noMens = cerrojo.newCondition();

    public void enviaMensaje(String msg) {
        cerrojo.lock();
        try{
            while (hayMensaje) {
                mens.await();
            }
            mensaje = msg;
            hayMensaje = true;
            noMens.signal();
        } catch(InterruptedException e) {}
        finally {
            cerrojo.unlock();
        }
    }

    public String recibeMensaje() {
        cerrojo.lock();
        try{
            while (!hayMensaje) {
                noMens.await();
            }
            hayMensaje = false;
            mens.signal();
            return mensaje;
        } catch(InterruptedException e) {
            return "Error";
        } finally {
            cerrojo.unlock();
        }
    }
}
