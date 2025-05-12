package Teoria.ExamenesAnteriores.Examen3.Mayo2012;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class E3 {
    public static void main(String[] args) {
        try {
            // Abro una conexión TCP con E2, es el servidor
            ArrayList<Integer> numeros = new ArrayList<>();

            ServerSocket servidorE3 = new ServerSocket(4000);
            Socket socket = servidorE3.accept();
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            System.out.println("Servidor E3 conectado");

            for (int i = 0; i < 10; i++) {
                int numero = entrada.readInt();
                System.out.println("E3 ha recibido de E2: " + numero);
                if(numero % 3 == 0) {
                    numeros.add(numero);
                }
            }

            entrada.close();
            socket.close();
            servidorE3.close();

            // Abro conexión UDP con E1, es el cliente
            DatagramSocket socketE1 = new DatagramSocket();
            byte[] buffer;
            InetAddress destino = InetAddress.getByName("localhost");
            DatagramPacket packet;

            for (int i = 0; i < numeros.size(); i++) {
                buffer = String.valueOf(numeros.get(i)).getBytes();
                packet = new DatagramPacket(buffer, buffer.length, destino, 3000);
                socketE1.send(packet);
            }

            buffer = String.valueOf(-10).getBytes();
            packet = new DatagramPacket(buffer, buffer.length, destino, 3000);
            socketE1.send(packet);

            socketE1.close();
        } catch (IOException e) {
            System.out.println("Error en el equipo E3: " + e.getMessage());
        }
    }
}
