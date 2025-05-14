package Teoria.ExamenesAnteriores.Examen3.Mayo2022;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ModuloMedicion {
    public static void main(String[] args) {
        try {
            InetAddress direccionServidorLocal = InetAddress.getByName("129.168.21.23");
            int puerto = 5000;

            DatagramSocket socket = new DatagramSocket(puerto);

            while (true){
                for (int i = 1; i < 6; i++){
                    int valorSensor = leerSensor(i);
                    String mensaje = i + ": " + valorSensor;
                    byte[] buffer = mensaje.getBytes();

                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, direccionServidorLocal, puerto);
                    socket.send(packet);
                }
                Thread.sleep(10000);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error en el Módulo de Medición: " + e.getMessage());
        }
    }

    private static int leerSensor(int idSensor){
        return (int)(Math.random() * 10);
    }
}
