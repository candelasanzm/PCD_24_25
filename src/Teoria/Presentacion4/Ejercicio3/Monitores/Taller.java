package Teoria.Presentacion4.Ejercicio3.Monitores;

import java.util.LinkedList;
import java.util.Queue;

public class Taller {
    private Queue<Pedido> pedidos;

    public Taller() {
        pedidos = new LinkedList<>();
    }

    public synchronized void dejarPedido(Pedido pedido) throws InterruptedException {
        pedidos.add(pedido);
        Thread.sleep(500);
        notifyAll();

        while(!pedido.getListo()){
            wait();
        }
    }

    public synchronized Pedido cogerPedido() throws InterruptedException {
        while(pedidos.isEmpty()){
            wait();
        }
        Pedido pedido = pedidos.poll(); // Retira el primer pedido (FIFO)
        return pedido;
    }

    public synchronized void terminarPedido(Pedido pedido){
        pedido.setListo(true);
        notifyAll();
    }
}
