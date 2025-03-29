package Teoria.Presentacion3.Parte2.Ejercicio4.Forma1;

public class Ejercicio4F1 {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();

        for (int i = 0; i < 20; i++){
            Cliente cliente = new Cliente(i + 1, tienda);
            cliente.start();
        }
    }
}
