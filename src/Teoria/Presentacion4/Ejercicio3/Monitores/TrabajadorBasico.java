package Teoria.Presentacion4.Ejercicio3.Monitores;

public class TrabajadorBasico extends Thread {
    private Taller taller;

    public TrabajadorBasico(Taller taller) {
        this.taller = taller;
    }

    public void run() {
        try {
            while (true){
                Pedido pedido = taller.cogerPedido();
                System.out.println("Trabajador coge pedido del cliente " + pedido.getIdCliente() + " (" + pedido.getNumLlaves() + ")");
                Thread.sleep(2000 * pedido.getNumLlaves());
                taller.terminarPedido(pedido);
                System.out.println("Trabajador termina pedido del cliente " + pedido.getIdCliente());
            }
        } catch (Exception e){}
    }
}
