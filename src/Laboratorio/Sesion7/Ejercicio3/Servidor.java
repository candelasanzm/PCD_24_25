package Laboratorio.Sesion7.Ejercicio3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor
{
    public static void main(String args[])
    {
        try
        {
            DatagramSocket servidor = new DatagramSocket(5000); // Creamos un DatagramSocket en el puerto 5000
            byte[] buffer = new byte[1024];

            System.out.println("Servidor UDP Arrancado....");
            while (true)
            {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                servidor.receive(packet);     // Esperamos una conexión

                String mensaje = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Mensaje recibido: " + mensaje);

                String respuesta = "¡Hola " + mensaje + ", bienvenido!";
                byte[] respuestaBytes = respuesta.getBytes();
                DatagramPacket paqueteRespuesta = new DatagramPacket(respuestaBytes, respuestaBytes.length, packet.getAddress(), packet.getPort());
                servidor.send(paqueteRespuesta);
            }
        } catch (IOException e) {}
    }
}
