package Teoria.ExamenesAnteriores.Examen2.Examen201516.Ejercicio2;

import java.util.concurrent.Callable;

public class TareaDoblado implements Callable<Prendas> {
    private int id;
    private Prendas prendas;

    public TareaDoblado(int id, Prendas prendas) {
        this.id = id;
        this.prendas = prendas;
    }

    public Prendas call(){
        System.out.println("Tarea de doblado " + id + " iniciada. Tipo de prenda " + prendas.getTipoString());
        try {
            Thread.sleep(100);
            prendas.setDoblada(true);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException al doblar la prenda " + e.toString());
            return prendas;
        }
        return prendas;
    }
}
