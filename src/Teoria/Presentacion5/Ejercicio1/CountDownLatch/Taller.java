package Teoria.Presentacion5.Ejercicio1.CountDownLatch;

import java.util.LinkedList;
import java.util.Queue;

public class Taller {
    private Queue<TrabajoPedido> trabajos;
    private TrabajoPedido trabajoActual;

    public Taller() {
        trabajos = new LinkedList<>();
        trabajoActual = null;
    }

    public synchronized void dejarPedido(Pedido pedido) throws InterruptedException {
        TrabajoPedido trabajador = new TrabajoPedido(pedido);
        trabajos.add(trabajador);
        System.out.println("Cliente " + pedido.getIdCliente() + " deja pedido de " + pedido.getNumLlaves() + " llaves");
        notifyAll();
        while (!pedido.isListo()){
            wait();
        }
    }

    public synchronized TrabajoPedido obtenerTrabajo() throws InterruptedException {
        while (trabajoActual == null){
            if (trabajos.isEmpty()){
                wait();
            } else {
                trabajoActual = trabajos.poll();
            }
        }
        return trabajoActual;
    }

    public synchronized void liberarTrabajo(){
        if (trabajoActual != null){
            trabajoActual.getPedido().setListo(true);
            trabajoActual = null;
            notifyAll();
        }
    }
}
