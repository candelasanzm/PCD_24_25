package Laboratorio.Sesion4.Ejercicio.Solucion1;

import javax.swing.*;
import java.awt.*;

public class Pintor extends Thread{
    private JButton b;
    private Paleta p;
    private int numPintor;
    private Color negro = Color.black;

    public Pintor(JButton b, Paleta p, int numPintor) {
        this.b=b;
        this.p=p;
        this.numPintor = numPintor;
    }

    public void run() {
        while (true) {
            b.setBackground(negro);                 //Pinta el botón de negro
            try {
                sleep((int)(200*Math.random()));    //Espera entre 0 y 0.2 seg.
            } catch (InterruptedException e){ }

            Color uno = p.tomaColor(numPintor);     //Toma de la paleta el primer color
            b.setBackground(uno);                   //y pinta el botón

            try {
                sleep((int)(50*Math.random()));     //Espera entre 0 y 0.05 seg.
            } catch (InterruptedException e){ }

            Color dos = p.tomaColor(numPintor+1);     //Toma de la paleta el segundo color
            Color mezcla = p.mezclaColores(uno, dos); //los mezcla
            b.setBackground(mezcla);                  //y pinta el botón

            try {
                sleep((int)(100*Math.random()));  //Espera entre 0 y 0.1 seg.
            } catch (InterruptedException e){ }

            p.dejaColor(numPintor);
            p.dejaColor(numPintor+1);
        }
    }
}
