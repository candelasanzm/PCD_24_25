package Teoria.Presentacion4.Ejercicio1.Monitores;

public class Main {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante(20);
        Camarero camarero1 = new Camarero(1, restaurante);
        Camarero camarero2 = new Camarero(2, restaurante);
        Cocinero cocinero1 = new Cocinero(restaurante, 1);
        Cocinero cocinero2 = new Cocinero(restaurante, 2);

        camarero1.start();
        camarero2.start();
        cocinero1.start();
        cocinero2.start();
    }
}
