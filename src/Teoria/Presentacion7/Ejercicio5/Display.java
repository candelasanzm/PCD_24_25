package Teoria.Presentacion7.Ejercicio5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

public class Display {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(5000);
        System.out.println("Display arrancado");

        ArrayList<Integer> temperaturas  = new ArrayList<>();
        ArrayList<Integer> humedades = new ArrayList<>();

        while (true) {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String datos = new String(packet.getData(), 0, packet.getLength()).trim();
            String[] valores = datos.split(", ");

            int temperatura = Integer.parseInt(valores[0]);
            int humedad = Integer.parseInt(valores[1]);

            temperaturas.add(temperatura);
            humedades.add(humedad);

            System.out.println("Display recibió: temperatura " + temperatura + ", humedad " + humedad);

            if (temperaturas.size() == 10 && humedades.size() == 10){
                calcularMedias(temperaturas, humedades);
                temperaturas.clear();
                humedades.clear();
            }
        }
    }

    private static void calcularMedias(ArrayList<Integer> temperaturas, ArrayList<Integer> humedades) {
        double mediaTemperatura = (double) (temperaturas.get(0) + temperaturas.get(1) + temperaturas.get(2) + temperaturas.get(3) + temperaturas.get(4) + temperaturas.get(5) + temperaturas.get(6) + temperaturas.get(7) + temperaturas.get(8) + temperaturas.get(9)) / 10;
        double mediaHumedades = (double) (humedades.get(0) + humedades.get(1) + humedades.get(2) + humedades.get(3) + humedades.get(4) + humedades.get(5) + humedades.get(6) + humedades.get(7) + humedades.get(8) + humedades.get(9)) / 10;
        System.out.println("Temperatura media: " + mediaTemperatura);
        System.out.println("Humedades media: " + mediaHumedades);
    }
}
