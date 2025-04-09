package Teoria.Presentacion5.Ejercicio1.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class TrabajoPedido {
    private Pedido pedido;
    private CyclicBarrier cyclicBarrier;

    public TrabajoPedido(Pedido pedido) {
        this.pedido = pedido;
        this.cyclicBarrier = new CyclicBarrier(2, () -> {System.out.println("Llave completada para cliente " + pedido.getIdCliente());});
    }

    public Pedido getPedido() {
        return pedido;
    }

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }
}
