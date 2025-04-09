package Teoria.Presentacion5.Ejercicio1.Exchanger;

import java.util.concurrent.Exchanger;

public class TrabajoPedido {
    private Pedido pedido;
    private Exchanger<String> exchanger;

    public TrabajoPedido(Pedido pedido) {
        this.pedido = pedido;
        this.exchanger = new Exchanger<>();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Exchanger<String> getExchanger() {
        return exchanger;
    }
}
