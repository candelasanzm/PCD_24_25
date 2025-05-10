package Teoria.Presentacion7.Ejercicio4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(5000);
        System.out.println("Servidor UDP Arrancado");

        while (true) {
            byte[] buffer = new byte[1024];
            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(paquete);

            String pedido = new String(paquete.getData(), 0, paquete.getLength()).trim();
            System.out.println("Pedido recibido: " + pedido);

            String[] datosPedido = pedido.split(", ");
            int idEmpleado = Integer.parseInt(datosPedido[0]);
            int cantidadProductos = Integer.parseInt(datosPedido[1]);
            int precioTotal = Integer.parseInt(datosPedido[2]);

            int respuesta = validarRespuestas(idEmpleado, cantidadProductos, precioTotal);

            String mensaje = String.valueOf(respuesta);
            buffer = mensaje.getBytes();
            InetAddress direccionCaja = paquete.getAddress();
            int puertoCaja = paquete.getPort();

            DatagramPacket paqueteRespuesta = new DatagramPacket(buffer, buffer.length, direccionCaja, puertoCaja);
            datagramSocket.send(paqueteRespuesta);
        }

    }

    private static int validarRespuestas(int idEmpleado, int productosCobrados, int precioTotal){
        if (idEmpleado < 1 || idEmpleado > 1000 || productosCobrados < 1 || productosCobrados > 1000 || precioTotal < 1 || precioTotal > 1000){
            return -1;
        }
        return 1;
    }
}
