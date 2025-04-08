package Teoria.Presentacion4.Ejercicio3.Monitores;

public class TrabajadorOpcional2 extends Thread {
    private Taller taller;

    public TrabajadorOpcional2(Taller taller) {
        this.taller = taller;
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        try {
            while (System.currentTimeMillis() - startTime < 25000){
                Pedido pedido = taller.cogerPedido();
                System.out.println("Trabajador coge pedido del cliente " + pedido.getIdCliente() + " (" + pedido.getNumLlaves() + ")");
                Thread.sleep(2000 * pedido.getNumLlaves());
                taller.terminarPedido(pedido);
                System.out.println("Trabajador termina pedido del cliente " + pedido.getIdCliente());
            }
            System.out.println("Trabajador finaliza su turno después de 25 segundos");
        } catch (Exception e){}
    }
}
