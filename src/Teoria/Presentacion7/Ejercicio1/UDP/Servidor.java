package Teoria.Presentacion7.Ejercicio1.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.time.LocalDate;
import java.time.Period;

public class Servidor {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(5000);
        System.out.println("Servidor UDP conectado");

        String recibido = null;

        do {
            try {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                recibido = new String(packet.getData(), 0, packet.getLength());

                int edad = calcularEdad(recibido);
                String respuesta = "Tu edad es: " + edad + " años";

                buffer = respuesta.getBytes();
                InetAddress destino = packet.getAddress();
                int puerto = packet.getPort();

                packet = new DatagramPacket(buffer, buffer.length, destino, puerto);
                socket.send(packet);
            } catch (IOException e){}
        } while (!recibido.equals("ciao"));
        socket.close();
        System.out.println("Cerrando el servidor");
    }

    private static int calcularEdad(String fechaDeNacimiento) {
        LocalDate nacimiento = LocalDate.parse(fechaDeNacimiento);
        LocalDate fecha = LocalDate.now();
        return Period.between(nacimiento, fecha).getYears();
    }
}
