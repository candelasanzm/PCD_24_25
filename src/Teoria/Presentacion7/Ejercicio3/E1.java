package Teoria.Presentacion7.Ejercicio3;

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
        try{
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            String entradaConsola = null;

            // Abro una conexión TCP para enviar los datos a E2
            Socket clienteE2 = new Socket(InetAddress.getLocalHost(), 5000);
            DataOutputStream salida = new DataOutputStream(clienteE2.getOutputStream());

            int contador = 0;
            while (contador < 5){
                System.out.println("Introduzca un número positivo: ");
                entradaConsola = teclado.readLine();

                int numero = Integer.parseInt(entradaConsola);
                if (numero > 0){
                    salida.writeInt(numero);
                    contador++;
                } else {
                    System.out.println("Número no válido.");
                }
            }

            salida.close();
            clienteE2.close();

            // Abro una conexión UDP para enviar los datos a E3
            DatagramSocket servidorUDP = new DatagramSocket(4000);
            System.out.println("Servidor UDP E3 arrancado");

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            String recibidoE3 = "";

            while(!recibidoE3.equals("-10")){
                servidorUDP.receive(packet);
                recibidoE3 = new String(packet.getData(), 0, packet.getLength());
                System.out.println("E1 ha recibido desde E3 " + recibidoE3);
            }

            servidorUDP.close();

        } catch (IOException e){
            System.out.println("Error en el equipo E1: " + e.getMessage());
        }
    }
}
