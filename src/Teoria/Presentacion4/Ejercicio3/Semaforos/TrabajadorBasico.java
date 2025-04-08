package Teoria.Presentacion4.Ejercicio3.Semaforos;

public class TrabajadorBasico extends Thread {
    private ServicioLlaves servicioLlaves;

    public TrabajadorBasico(ServicioLlaves servicioLlaves) {
        this.servicioLlaves = servicioLlaves;
    }

    public void run(){
        try {
            for (int i = 0; ; i++){ // El trabajador no para nunca
                Pedido pedido = new Pedido(i, (int) (Math.random() * 3) + 1);
                servicioLlaves.procesarPedido(pedido);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
