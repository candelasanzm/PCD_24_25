package Teoria.Presentacion4.Ejercicio3.Semaforos;

public class Cliente extends Thread {
    private ServicioLlaves servicioLlaves;
    private int idCliente;

    public Cliente(ServicioLlaves servicioLlaves, int idCliente) {
        this.servicioLlaves = servicioLlaves;
        this.idCliente = idCliente;
    }

    public void run() {
        try {
            Thread.sleep(2000 * idCliente);
            Pedido pedido = new Pedido(idCliente, (int) (Math.random() * 3) + 1);
            servicioLlaves.dejarPedido(pedido);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
