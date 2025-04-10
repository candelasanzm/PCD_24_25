package Teoria.Presentacion6.Ejercicio3;

import java.util.Random;

public class Cliente implements Runnable {
    private final int idCliente;
    private final Random random = new Random();

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public void run() {
        int productos = random.nextInt(18) + 3;
        double precioProducto = 3.0;
        double totalCompra = 0;

        System.out.println("Cliente " + idCliente + " está en la caja con " + productos + " productos");

        for (int i = 1; i <= productos; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Error en el cliente " + idCliente);
            }
            totalCompra += precioProducto;
        }
        System.out.println("Cliente " + idCliente + " ha finalizado su compra. Total " + totalCompra + " euros");
    }
}
