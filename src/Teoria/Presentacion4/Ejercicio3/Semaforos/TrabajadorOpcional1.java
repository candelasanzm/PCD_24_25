package Teoria.Presentacion4.Ejercicio3.Semaforos;

public class TrabajadorOpcional1 extends Thread {
    private ServicioLlaves servicioLlaves;

    public TrabajadorOpcional1(ServicioLlaves servicioLlaves) {
        this.servicioLlaves = servicioLlaves;
    }

    public void run(){
        try {
            int llavesProcesadas = 0;
            while (llavesProcesadas < 20){ // El trabajador no para nunca
                Pedido pedido = new Pedido(llavesProcesadas, (int) (Math.random() * 3) + 1);
                servicioLlaves.procesarPedido(pedido);
                llavesProcesadas += pedido.getNumLlaves();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
