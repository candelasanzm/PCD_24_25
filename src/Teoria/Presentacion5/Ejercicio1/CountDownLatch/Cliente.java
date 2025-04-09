package Teoria.Presentacion5.Ejercicio1.CountDownLatch;

public class Cliente extends Thread {
    private Taller taller;
    private int id;

    public Cliente(Taller taller, int id) {
        this.taller = taller;
        this.id = id;
    }

    public void run() {
        try {
            int numLlaves = (int) (Math.random() * 3) + 1;
            Pedido pedido = new Pedido(id, numLlaves);
            taller.dejarPedido(pedido);
            System.out.println("Cliente " + id + " paga y se va");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
