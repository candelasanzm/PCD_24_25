package Laboratorio.Sesion1.Ejercicio5;

import javax.swing.*;
import java.awt.*;

public class Pintor extends Thread {
    JButton b;
    Color paleta[] = new Color[10];

    public Pintor(JButton b){
        this.b=b;
        paleta[0] = Color.BLACK;
        paleta[1] = Color.RED;
        paleta[2] = Color.GREEN;
        paleta[3] = Color.BLUE;
        paleta[4] = Color.YELLOW;
        paleta[5] = Color.MAGENTA;
        paleta[6] = Color.CYAN;
        paleta[7] = Color.PINK;
        paleta[8] = Color.ORANGE;
        paleta[9] = Color.GRAY;
    }

    public void run(){
        while (true){
            int i = (int)(10. * Math.random());
            b.setBackground(paleta[i]);
        }
    }
}
