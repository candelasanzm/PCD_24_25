package Teoria.Presentacion3.Parte2.Ejercicio3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Restaurante {
    private Lock cerrojo = new ReentrantLock();
    private Condition lleno = cerrojo.newCondition();
    private Condition vacio = cerrojo.newCondition();

    private int maximoComandas;
    private String[] comandas;
    private int numElementos = 0;
    private int in = 0;
    private int out = 0;

    public Restaurante(int maximoComandas) {
        this.maximoComandas = maximoComandas;
        comandas = new String[maximoComandas];
    }

    public void dejarComanda(String comanda) throws InterruptedException {
        cerrojo.lock();
        try {
            while (numElementos == maximoComandas) {
                System.out.println("Estanteria llena");
                lleno.await();
            }
            comandas[in] = comanda;
            numElementos++;
            in = (in + 1) % maximoComandas;
            System.out.println("Se añadió comanda " + comanda);
            vacio.signal(); // ya no está vacío
        } finally {
            cerrojo.unlock();
        }
    }

    public String cogerComanda() throws InterruptedException {
        cerrojo.lock();
        try{
            while (numElementos == 0) {
                System.out.println("Estanteria vacía");
                vacio.await();
            }
            String comanda = comandas[out];
            comandas[out] = null;
            numElementos--;
            out = (out + 1) % maximoComandas;
            lleno.signal(); //hay hueco
            return comanda;
        } finally {
            cerrojo.unlock();
        }
    }
}
