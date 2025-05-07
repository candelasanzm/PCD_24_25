package Laboratorio.Sesion7.Ejercicio2.ApartadoC;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ManejadorCliente extends Thread {
    private Socket socket;

    public ManejadorCliente(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            String mensaje = entrada.readUTF();
            System.out.println("Mensaje recibido de " + socket.getInetAddress().getHostName() + ": " + mensaje);
            salida.writeUTF("¡Hola " + mensaje + ", bienvenido al servidor multihilo!");

            socket.close();
        } catch (IOException e){
            System.out.println("Error en el manejador del cliente " + e.getMessage());
        }
    }
}
