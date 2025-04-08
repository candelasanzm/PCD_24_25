package Teoria.Presentacion4.Ejercicio6.Monitores;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();

        for (int i = 0; i < 20; i++) {
            Cliente cliente = new Cliente(i, tienda);
            cliente.start();
        }
    }
}
