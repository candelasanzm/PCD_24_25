package Teoria.ExamenesAnteriores.Examen2.Examen202122;

import java.util.concurrent.atomic.AtomicInteger;

public class Comedero {
    private int avesEnComedero;
    private String tipoAveComiendo;
    private boolean aguilaPresente;
    private AtomicInteger avesMuertas;

    public Comedero(){
        avesEnComedero = 0;
        tipoAveComiendo = "";
        aguilaPresente = false;
        avesMuertas = new AtomicInteger(0);
    }

    public synchronized boolean entrarComedero(String tipoAve) throws InterruptedException{
        if (aguilaPresente){
            return false;
        } else {
            while (avesEnComedero == 2 || (!tipoAveComiendo.isEmpty() && !tipoAveComiendo.equals(tipoAve))){
                if (tipoAve.equals("ESP-A") && tipoAveComiendo.equals("ESP-INV")){
                    avesMuertas.incrementAndGet();
                    return false;
                }
                wait();
            }
            avesEnComedero++;
            tipoAveComiendo = tipoAve;
            return true;
        }
    }

    public synchronized void salirComedero(){
        avesEnComedero--;
        if (avesEnComedero == 0){
            tipoAveComiendo = "";
        }
        notifyAll();
    }

    public synchronized void entrarAguila() throws InterruptedException{
        while (avesEnComedero > 0){
            avesEnComedero = 0;
            tipoAveComiendo = "";
            notifyAll();
        }
        aguilaPresente = true;
        System.out.println("El águila está comiendo");
        Thread.sleep((int)(Math.random() * 3000) + 3000);
        aguilaPresente = false;
        notifyAll();
    }

    public void imprimirResultados(int totalAves){
        System.out.println("Total de aves muertas: " + avesMuertas.get());
        System.out.println("Total de aves que lograron comer " + (totalAves - avesMuertas.get()));
    }
}
