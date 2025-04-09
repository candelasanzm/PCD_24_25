package Teoria.Presentacion5.Ejercicio1.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class TrabajoPedido {
    private Pedido pedido;
    private CountDownLatch[] latchPorLlave;

    public TrabajoPedido(Pedido pedido) {
        this.pedido = pedido;
        int numLlaves = pedido.getNumLlaves();
        latchPorLlave = new CountDownLatch[numLlaves];
        for (int i = 0; i < numLlaves; i++) {
            latchPorLlave[i] = new CountDownLatch(2);
        }
    }

    public Pedido getPedido() {
        return pedido;
    }

    public CountDownLatch getLatchPorLlave(int i) {
        if (i < 0 || i >= latchPorLlave.length) {
            throw new IllegalArgumentException("Índice de llave inválido");
        }
        return latchPorLlave[i];
    }
}
