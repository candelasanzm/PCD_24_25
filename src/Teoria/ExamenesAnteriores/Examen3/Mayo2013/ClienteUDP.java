package Teoria.ExamenesAnteriores.Examen3.Mayo2013;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class ClienteUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            Random random = new Random();

            for (int i = 0; i < 10; i++) {
                String nombre = "Producto_" + random.nextInt(100);
                int cantidad = random.nextInt(100);
                int precio = random.nextInt(100);

                String pedido = nombre + ", " + cantidad + ", " + precio;
                byte[] buffer = pedido.getBytes();

                InetAddress direccionServidor = InetAddress.getByName("127.0.0.1");
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, direccionServidor, cantidad);
                socket.send(packet);

                byte[] respuestaBuffer = new byte[1024];
                DatagramPacket paqueteRespuesta = new DatagramPacket(respuestaBuffer, respuestaBuffer.length);
                socket.receive(paqueteRespuesta);
                String respuesta = new String(paqueteRespuesta.getData(), 0, paqueteRespuesta.getLength());

                System.out.println("La respuesta del servidor es: " + respuesta);
            }
        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
