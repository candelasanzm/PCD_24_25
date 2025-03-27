package Laboratorio.Sesion3.Ejemplo2;

import java.awt.Color;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// La clase Paleta contiene los cuatro colores del parchís y los sirve a los pintores

public class Paleta {
    Lock cerrojo = new ReentrantLock();
    private Color [] colores = new Color[4];
    private boolean[] libre = new boolean[4];

    public Paleta() {
        colores[0]=Color.red;
        colores[1]=Color.blue;
        colores[2]=Color.green;
        colores[3]=Color.yellow;
        for(int i=0; i<4; i++) {
            libre[i]=true;
        }
    }

    public Color tomaColor() {
        cerrojo.lock();
        try {
            int i=0;
            boolean salir = false;
            while(!salir) {
                i = (int)(4 * Math.random());  //Elige color al azar
                if(libre[i]) {
                    libre[i]=false;
                    salir = true;
                }
            }
            return colores[i];
        } finally {
            cerrojo.unlock();
        }
    }

    public void dejaColor(Color c) {
        cerrojo.lock();
        try {
            for(int i=0; i<4; i++) {
                if(c.equals(colores[i])) {
                    libre[i]=true;
                }
            }
        } finally {
            cerrojo.unlock();
        }
    }
}
