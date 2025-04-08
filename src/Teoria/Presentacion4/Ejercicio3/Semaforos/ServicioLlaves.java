package Teoria.Presentacion4.Ejercicio3.Semaforos;

import java.util.concurrent.Semaphore;

public class ServicioLlaves {
    private Semaphore semaforoCliente = new Semaphore(0);
    private Semaphore semaforoTrabajador = new Semaphore(0);

    public void dejarPedido(Pedido pedido) throws InterruptedException {
        System.out.println("Cliente " + pedido.getIdCliente() + " entrega pedido de " + pedido.getNumLlaves() + " llaves");
        semaforoCliente.release(); // Notifica que hay un nuevo pedido
        semaforoTrabajador.acquire(); // Espera hasta que el pedido termine
        System.out.println("Cliente " + pedido.getIdCliente() + " paga y se va");
    }

    public void procesarPedido(Pedido pedido) throws InterruptedException {
        semaforoCliente.acquire(); // Espera hasta que haya un pedido
        System.out.println("Trabajador procesa pedido de " + pedido.getNumLlaves() + " llaves");
        Thread.sleep(2000 * pedido.getNumLlaves());
        semaforoTrabajador.release();
    }
}
