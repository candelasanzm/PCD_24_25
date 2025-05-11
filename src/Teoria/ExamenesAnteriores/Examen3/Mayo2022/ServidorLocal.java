package Teoria.ExamenesAnteriores.Examen3.Mayo2022;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorLocal {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(5000);
            byte[] buffer = new byte[1024];

            AccionesServicioRMI accionesServicioRMI = new AccionesServicioRMI();

            Registry registry = LocateRegistry.createRegistry(1100);
            registry.rebind("ServidorCentral", accionesServicioRMI);

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String recibido = new String(packet.getData(), 0, packet.getLength());

                String[] datos = recibido.split(":");
                int sensorID = Integer.parseInt(datos[0]);
                int valor = Integer.parseInt(datos[1]);

                System.out.println(packet.getAddress().getHostAddress() + ". Sensor: " + sensorID + ". Valor: " + valor);

                if (sensorID == 5 && valor == 1) {
                    accionesServicioRMI.llamarBomberos(packet.getAddress().getHostAddress());
                }

                accionesServicioRMI.guardarEstado(packet.getAddress().getHostAddress(), sensorID, valor);
            }
        } catch (IOException e) {
            System.out.println("Error en el Servidor Local: " + e.getMessage());
        }
    }
}
