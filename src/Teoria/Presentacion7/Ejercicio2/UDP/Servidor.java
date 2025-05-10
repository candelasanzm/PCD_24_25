package Teoria.Presentacion7.Ejercicio2.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(5000);
        System.out.println("Servidor UDP arrancado");

        int value;

        try{
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String recibido = new String(packet.getData(), 0, packet.getLength());

            value = Integer.parseInt(recibido);
            boolean esPrimo = numeroPrimo(value);

            String mensaje = "El número " + value + (esPrimo ? " es primo" : " no es primo");

            buffer = mensaje.getBytes();
            InetAddress destino = packet.getAddress();
            int puerto = packet.getPort();

            packet = new DatagramPacket(buffer, buffer.length, destino, puerto);
            socket.send(packet);
        } catch (IOException e){}
        socket.close();
        System.out.println("Cerrando servidor");
    }

    private static boolean numeroPrimo(int numero){
        if (numero <= 1){
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(numero); i++){
                if(numero % i == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
