package Teoria.Presentacion4.Ejercicio2.Monitores;

public class Ejercicio2 {
    public static void main(String[] args) {
        Corral corral = new Corral();

        for (int i = 0; i < 29; i++) {
            Pollo pollo = new Pollo(i, corral);
            pollo.start();
        }
    }
}
