package Teoria.ExamenesAnteriores.Examen3.Mayo2012;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class E1 {
    public static void main(String[] args) {
        try {
            // Abro conexión TCP para la comunicación con E2, este es el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            String entradaConsola = null;

            Socket clienteE2 = new Socket(InetAddress.getLocalHost(), 5000);
            DataOutputStream salida = new DataOutputStream(clienteE2.getOutputStream());

            int contador = 0;
            while (contador < 5){
                System.out.println("Introduzca un número positivo: ");
                entradaConsola = entrada.readLine();

                int numero = Integer.parseInt(entradaConsola);
                if (numero > 0){
                    salida.writeInt(numero);
                    contador++;
                } else {
                    System.out.println("Número no válido");
                }
            }

            salida.close();
            clienteE2.close();

            // Abro conexión UDP para la comunicación con E3, es el servidor
            DatagramSocket socket = new DatagramSocket(3000);
            System.out.println("Servidor UDP E3 conectado");

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            String recibido = "";

            while(!recibido.equals("-10")){
                socket.receive(packet);
                recibido = new String(packet.getData(), 0, packet.getLength());
                System.out.println("E1 ha recibido de E3: " + recibido);
            }

            socket.close();
        } catch (IOException ex) {
            System.out.println("Error en el equipo E1: " + ex.getMessage());
        }
    }
}
