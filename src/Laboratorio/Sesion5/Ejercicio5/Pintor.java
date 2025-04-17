package Laboratorio.Sesion5.Ejercicio5;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Exchanger;

public class Pintor extends Thread{
    private JButton b;
    private Exchanger<Color> vecino;
    private Exchanger<Color> miExchanger;
    private Color colorActual;
    private boolean detenido = false;
    private Object pausa = new Object();

    public Pintor(JButton b, Color colorInicial, Exchanger<Color> vecino, Exchanger<Color> miExchanger) {
        this.b = b;
        this.colorActual = colorInicial;
        this.vecino = vecino;
        this.miExchanger = miExchanger;
    }

    public void detener(){
        detenido = true;
    }

    public void reanudar(){
        synchronized (pausa){
            detenido = false;
            pausa.notifyAll();
        }
    }

    private void verificarPausa(){
        synchronized (pausa){
            while (detenido){
                try {
                    pausa.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void run() {
        try {
            while (true){
                verificarPausa();

                // Pintar el botón de negro
                b.setBackground(Color.black);
                Thread.sleep((int) (Math.random() * 200));

                // Pintar el botón actual con el color actual
                b.setBackground(colorActual);
                Thread.sleep((int) (Math.random() * 200));

                // Intercambiar color con el vecino
                Color nuevoColor = vecino.exchange(colorActual);
                colorActual = nuevoColor;
            }
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
