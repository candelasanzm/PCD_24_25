package Teoria.Presentacion5.Ejercicio1.CyclicBarrier;

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
                    trabajoPedido.getCyclicBarrier().await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
