package Teoria.Presentacion4.Ejercicio6.Semaforos;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();

        for (int i = 0; i < 20; i++){
            Cliente cliente = new Cliente(i + 1, tienda);
            cliente.start();
        }
    }
}
