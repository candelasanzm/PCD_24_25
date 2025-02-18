package Laboratorio.Sesion2.Ejemplo3;
import java.awt.Color;

// La clase pr.Paleta contiene los cuatro colores del parchís y los sirve a los pintores
public class Paleta {

    private Color [] colores = new Color[4];

    public Paleta() {
        colores[0]=Color.red;
        colores[1]=Color.blue;
        colores[2]=Color.green;
        colores[3]=Color.yellow;
    }

    public Color tomaColor() {
        int i = (int)(4 * Math.random());  //Elige color al azar
        return colores[i];
    }
}