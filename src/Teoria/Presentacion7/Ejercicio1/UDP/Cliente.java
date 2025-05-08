package Teoria.Presentacion7.Ejercicio1.UDP;

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

        do{
            System.out.print("Introduce tu fecha de nacimiento (YYYY-MM-DD) o 'ciao' para salir: ");
            entradaConsola = entrada.readLine();
            byte[] entradaBytes = entradaConsola.getBytes();
            DatagramPacket paquete = new DatagramPacket(entradaBytes, entradaBytes.length, address, 5000);
            socket.send(paquete);
            entradaBytes = new byte[1024];
            paquete = new DatagramPacket(entradaBytes, entradaBytes.length);
            socket.receive(paquete);
            String recibido = new String(paquete.getData(), 0, paquete.getLength());
            System.out.println(recibido);
        } while(!entradaConsola.equals("ciao"));
        socket.close();
    }
}
