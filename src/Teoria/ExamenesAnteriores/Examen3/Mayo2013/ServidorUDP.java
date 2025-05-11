package Teoria.ExamenesAnteriores.Examen3.Mayo2013;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(5000);
            byte[] buffer = new byte[1024];

            System.out.println("Servidor Arrancado");

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String mensaje = new String(packet.getData(), 0, packet.getLength());
                InetAddress direccionCliente = packet.getAddress();
                int puerto = packet.getPort();

                String[] datos = mensaje.split(", ");
                if (datos.length == 3) {
                    String nombre = datos[0];
                    int cantidad = Integer.parseInt(datos[1]);
                    int precio = Integer.parseInt(datos[2]);

                    Pedido pedido = new Pedido();
                    int resultado = pedido.lineaPedidoNueva(nombre, cantidad, precio);

                    String respuesta = String.valueOf(resultado);
                    byte[] respuestaByte = respuesta.getBytes();
                    DatagramPacket paqueteEnviar = new DatagramPacket(respuestaByte, respuestaByte.length, direccionCliente, puerto);
                    socket.send(paqueteEnviar);

                    System.out.println("Respuesta enviada al cliente: " + respuesta);
                } else {
                    System.out.println("Error en el formato del pedido");
                }
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
