package Teoria.Presentacion7.Ejercicio2.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String entradaConsola = null;

        try {
            System.out.println("Introduce un número positivo mayor que uno: ");
            entradaConsola = entrada.readLine();

            byte[] entradaBytes = entradaConsola.getBytes();
            DatagramPacket packet = new DatagramPacket(entradaBytes, entradaBytes.length, address, 5000);
            socket.send(packet);

            entradaBytes = new byte[1024];
            packet = new DatagramPacket(entradaBytes, entradaBytes.length);
            socket.receive(packet);
            String recibido = new String(packet.getData(), 0, packet.getLength());
            System.out.println(recibido);
        } finally {
            socket.close();
        }
    }
}
