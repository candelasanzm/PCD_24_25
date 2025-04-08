package Teoria.Presentacion4.Ejercicio3.Monitores;

public class TrabajadorOpcional1 extends Thread {
    private Taller taller;
    private int maxLlaves = 20;
    private int llavesProcesadas = 0;

    public TrabajadorOpcional1(Taller taller) {
        this.taller = taller;
    }

    public void run() {
        try {
            while (llavesProcesadas < maxLlaves){
                Pedido pedido = taller.cogerPedido();
                System.out.println("Trabajador coge pedido del cliente " + pedido.getIdCliente() + " (" + pedido.getNumLlaves() + ")");
                Thread.sleep(2000 * pedido.getNumLlaves());
                llavesProcesadas += pedido.getNumLlaves();
                taller.terminarPedido(pedido);
                System.out.println("Trabajador termina pedido del cliente " + pedido.getIdCliente());
            }
            System.out.println("Trabajador finaliza tras duplicar " + llavesProcesadas + " llaves");
        } catch (Exception e){}
    }
}
