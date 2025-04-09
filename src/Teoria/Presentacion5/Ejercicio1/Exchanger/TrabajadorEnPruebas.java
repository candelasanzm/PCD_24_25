package Teoria.Presentacion5.Ejercicio1.Exchanger;

import java.util.concurrent.Exchanger;

public class TrabajadorEnPruebas extends Thread {
    private Taller taller;

    public TrabajadorEnPruebas(Taller taller) {
        this.taller = taller;
    }

    public void run() {
        while(true){
            try {
                TrabajoPedido trabajoPedido = taller.obtenerTrabajo();
                Pedido pedido = trabajoPedido.getPedido();
                int numLlaves = pedido.getNumLlaves();
                Exchanger<String> exchanger = trabajoPedido.getExchanger();

                for (int i = 0; i < numLlaves; i++) {
                    System.out.println("Trabajador en pruebas duplica llave " + (i + 1) + " del cliente " + pedido.getIdCliente());
                    Thread.sleep(2000);
                    String respuesta = exchanger.exchange("Listo Duplicado");
                    System.out.println("Llave " + (i + 1) + " completada para cliente " + pedido.getIdCliente());
                }

                taller.liberarTrabajo();
            } catch (Exception e){}
        }
    }
}
