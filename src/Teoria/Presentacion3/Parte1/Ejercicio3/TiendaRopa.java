package Teoria.Presentacion3.Parte1.Ejercicio3;

public class TiendaRopa {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();

        for (int i = 1; i < 10; i++) {
            Cliente cliente = new Cliente(i, tienda);
            cliente.start();
        }
    }
}
