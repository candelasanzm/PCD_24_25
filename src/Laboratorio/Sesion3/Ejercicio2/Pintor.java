package Laboratorio.Sesion3.Ejercicio2;

import javax.swing.*;
import java.awt.*;

public class Pintor extends Thread{
    private JButton b;
    private Paleta p;
    private Color negro = Color.black;
    private Paso paso;

    public Pintor(JButton b, Paleta p) {
        this.b=b;
        this.p=p;
        this.paso = new Paso();
    }

    public Paso getPaso(){
        return paso;
    }

    public void run() {
        while (true) {
            b.setBackground(negro);     //Pinta el botón de negro
            try {
                sleep(500 + (int)(1500*Math.random()));  //Espera entre 0.5 y 2 seg.
            } catch (InterruptedException e){}
            paso.mirar();              //Mira a ver si tiene que detenerse
            Color c=p.tomaColor();     //Toma un color cualquiera de la paleta
            b.setBackground(c);        //y pinta con él el botón
            try {
                sleep(1000 + (int)(2000*Math.random()));  //Espera entre 1 y 3 seg.
            } catch (InterruptedException e){}
            paso.mirar();             //Mira a ver si tiene que detenerse
            p.dejaColor(c);           // Libera el color utilizado
        }
    }
}
