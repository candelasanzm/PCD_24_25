package Teoria.Presentacion4.Ejercicio1.Semaforos;

public class Ejercicio1 {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante(20);
        Camarero camarero1 = new Camarero(1, restaurante);
        Camarero camarero2 = new Camarero(2, restaurante);
        Cocinero cocinero1 = new Cocinero(1, restaurante);
        Cocinero cocinero2 = new Cocinero(2, restaurante);

        camarero1.start();
        camarero2.start();
        cocinero1.start();
        cocinero2.start();
    }
}
