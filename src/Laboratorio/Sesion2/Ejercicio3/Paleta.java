package Laboratorio.Sesion2.Ejercicio3;
import java.awt.Color;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// La clase pr.Paleta contiene los cuatro colores del parchís y los sirve a los pintores
public class Paleta {

    Lock cerrojo = new ReentrantLock();
    private Color [] colores = new Color[4];
    private Boolean [] listaDisponibles = new Boolean[4];

    public Paleta() {
        colores[0] = Color.red;
        colores[1] = Color.blue;
        colores[2] = Color.green;
        colores[3] = Color.yellow;

        listaDisponibles[0] = true;
        listaDisponibles[1] = true;
        listaDisponibles[2] = true;
        listaDisponibles[3] = true;
    }

    public Color tomaColor() {
        cerrojo.lock();

        int pos = (int)(4 * Math.random());  //Elige color al azar
        try {
            while (! listaDisponibles[pos]) {
                pos = (int)(4 * Math.random());
            }
            listaDisponibles[pos] = false;
        } catch (Exception e) {}
        finally {
            cerrojo.unlock();
        }
        return colores[pos];
    }

    public Boolean[] dejarColor(Color color){
        for (int i = 0; i < colores.length; i++) {
            if (colores[i] == color) {
                listaDisponibles[i] = true;
            }
        }
        return listaDisponibles;
    }
}