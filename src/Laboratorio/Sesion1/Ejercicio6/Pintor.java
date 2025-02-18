package Laboratorio.Sesion1.Ejercicio6;

import javax.swing.*;
import java.awt.*;

public class Pintor extends Thread {
    JButton b;
    Color paleta[] = new Color[5];

    public Pintor(JButton b){
        this.b=b;
        paleta[0] = Color.BLACK;
        paleta[1] = Color.RED;
        paleta[2] = Color.GREEN;
        paleta[3] = Color.BLUE;
        paleta[4] = Color.YELLOW;
    }

    public void run(){
        while (true){
            int tiempo1 = 2000 + (int) (Math.random() * 3000);
            b.setBackground(paleta[0]);
            try {
                sleep(tiempo1);
            } catch (InterruptedException e) {}
            int i = 1 + (int)(4. * Math.random());
            b.setBackground(paleta[i]);
            int tiempo2 = 3000 + (int) (Math.random() * 4000);
            try {
                sleep(tiempo2);
            } catch (InterruptedException e) {}
        }
    }
}
