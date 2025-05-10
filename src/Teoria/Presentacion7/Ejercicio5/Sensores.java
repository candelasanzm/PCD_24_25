package Teoria.Presentacion7.Ejercicio5;

// Voy a usar UDP ya que al necesitar usar esperas es más eficiente usar UDP al no requerir confirmación de entrega ni establecer una conexión

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sensores {
    public static void main(String[] args) throws IOException {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress direccionDisplay = InetAddress.getByName("localhost");

            while (true){
                int temperatura = (int)(Math.random() * 50);
                int humedad = (int)(Math.random() * 100);

                String datos = temperatura + ", " + humedad;
                byte[] buffer = datos.getBytes();

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, direccionDisplay, 5000);
                socket.send(packet);

                System.out.println("Temperatura: " + temperatura + ", humedad: " + humedad);
                Thread.sleep((int) (Math.random() * 2000) + 1000);
            }

        } catch (Exception e) {
            System.out.println("Error en el sensor: " + e.getMessage());
        }
    }
}
