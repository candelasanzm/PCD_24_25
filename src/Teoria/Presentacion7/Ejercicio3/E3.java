package Teoria.Presentacion7.Ejercicio3;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class E3 {
    public static void main(String[] args) {
        try {
            ArrayList<Integer> numeros = new ArrayList<>();

            ServerSocket servidorE2 = new ServerSocket(3000);
            System.out.println("E3 esperando datos de E2");
            Socket conexionE2 = servidorE2.accept();

            DataInputStream entradaE2 = new DataInputStream(conexionE2.getInputStream());

            for(int i = 0; i < 10; i++){
                int numero = entradaE2.readInt();
                System.out.println("E3 ha recibido un mensaje de E2: " + numero);
                if (numero % 3 != 0){
                    numeros.add(numero);
                }
            }

            entradaE2.close();
            conexionE2.close();
            servidorE2.close();

            DatagramSocket clienteE1 = new DatagramSocket();
            byte[] buffer;
            InetAddress destinoE1 = InetAddress.getByName("localhost");
            DatagramPacket packet;

            for (int i = 0; i < numeros.size(); i++){
                buffer = String.valueOf(numeros.get(i)).getBytes();
                packet = new DatagramPacket(buffer, buffer.length, destinoE1, numeros.get(i));
                clienteE1.send(packet);
            }

            buffer = String.valueOf(-10).getBytes();
            packet =  new DatagramPacket(buffer, buffer.length, destinoE1, 4000);
            clienteE1.send(packet);

            clienteE1.close();
        } catch (IOException e){
            System.out.println("Error en el equipo E3: " + e.getMessage());
        }
    }
}
