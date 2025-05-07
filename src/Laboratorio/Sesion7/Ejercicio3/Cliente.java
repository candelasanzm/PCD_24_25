package Laboratorio.Sesion7.Ejercicio3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente
{
    public static void main(String args[])
    {
        try
        {
            DatagramSocket socket = new DatagramSocket();
            String mensaje = "Miguel Sánchez";
            byte[] buffer = mensaje.getBytes();
            InetAddress ip = InetAddress.getByName("192.168.0.124");

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, ip, 5000);
            socket.send(packet);

            byte[] bufferRespuesta = new byte[1024];
            DatagramPacket resp = new DatagramPacket(bufferRespuesta, bufferRespuesta.length);
            socket.receive(resp);

            String respuesta = new String(resp.getData(), 0, resp.getLength());
            System.out.println("Respuesta del servidor: " + respuesta);

            socket.close();
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
