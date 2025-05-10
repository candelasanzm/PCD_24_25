package Teoria.Presentacion7.Ejercicio4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress direccionServidor = InetAddress.getByName("localhost");

        for (int i = 0; i < 10; i++) {
            int idEmpleado = (int)(Math.random() * 1000) + 1;
            int cantidadProductos = (int) (Math.random() * 1000) + 1;
            int precioTotal = (int)(Math.random() * 1000) + 1;

            String pedido = idEmpleado + ", " + cantidadProductos + ", " + precioTotal;
            byte[] buffer = pedido.getBytes();

            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, direccionServidor, 5000);
            datagramSocket.send(paquete);
            System.out.println("Cliente envió pedido: " + pedido);

            buffer = new byte[1024];
            DatagramPacket paqueteRespuesta = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(paqueteRespuesta);

            int respuesta = Integer.parseInt(new String(paqueteRespuesta.getData()).trim());

            if (respuesta < 0){
                System.out.println("ERROR en el pedido: " + pedido);
            } else {
                System.out.println("Pedido aceptado");
            }
        }

        datagramSocket.close();
    }
}
