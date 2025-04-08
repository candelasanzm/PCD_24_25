package Teoria.Presentacion4.Ejercicio3.Semaforos;

public class TrabajadorOpcional2 extends Thread {
    private ServicioLlaves servicioLlaves;

    public TrabajadorOpcional2(ServicioLlaves servicioLlaves) {
        this.servicioLlaves = servicioLlaves;
    }

    public void run(){
        try {
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 25000){ // El trabajador no para nunca
                Pedido pedido = new Pedido((int) (Math.random() * 100), (int) (Math.random() * 3) + 1);
                servicioLlaves.procesarPedido(pedido);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
