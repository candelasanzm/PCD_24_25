package Teoria.Presentacion4.Ejercicio1.Semaforos;

import java.util.concurrent.Semaphore;

public class Restaurante {
    private Semaphore vacio = new Semaphore(0);
    private Semaphore lleno;
    private Semaphore em = new Semaphore(1);

    private int max;
    private String[] comandas;
    private int numElementos = 0;
    private int in = 0;
    private int out = 0;

    public Restaurante(int max) {
        this.max = max;
        comandas = new String[max];
        lleno = new Semaphore(max);
    }

    public void dejarComanda(String comanda) throws InterruptedException {
        lleno.acquire();
        em.acquire();
        comandas[in] = comanda;
        numElementos ++;
        in = (in + 1) % max;
        System.out.println("Se añadió comanda " + comanda);
        em.release();
        vacio.release();
    }

    public String cogerComanda() throws InterruptedException {
        vacio.acquire();
        em.acquire();
        String comanda = comandas[out];
        comandas[out] = null;
        numElementos --;
        out = (out + 1) % max;
        em.release();
        lleno.release();
        return comanda;
    }
}
