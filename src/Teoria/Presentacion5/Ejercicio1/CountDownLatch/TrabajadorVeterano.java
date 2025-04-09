package Teoria.Presentacion5.Ejercicio1.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class TrabajadorVeterano extends Thread {
    private Taller taller;

    public TrabajadorVeterano (Taller taller) {
        this.taller = taller;
    }

    public void run() {
        while (true) {
            try {
                TrabajoPedido trabajoPedido = taller.obtenerTrabajo();
                Pedido pedido = trabajoPedido.getPedido();
                int numLlaves = pedido.getNumLlaves();

                for (int i = 0; i < numLlaves; i++) {
                    Thread.sleep(2500);
                    System.out.println("Trabajador veterano revisa llave " + (i + 1) + " del cliente " + pedido.getIdCliente());
                    CountDownLatch latch = trabajoPedido.getLatchPorLlave(i);
                    latch.countDown();
                    latch.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
