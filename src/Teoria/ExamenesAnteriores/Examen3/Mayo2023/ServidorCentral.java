package Teoria.ExamenesAnteriores.Examen3.Mayo2023;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorCentral {
    private static ArrayList<String> valoraciones = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(30000);
                    imprimirValoraciones();
                } catch (InterruptedException e) {
                    System.out.println("Error en el thread: " + e.getMessage());
                }
            }
        }).start();

        ServerSocket serverSocket = new ServerSocket(5000);
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                DataInputStream entrada = new DataInputStream(socket.getInputStream());

                String valoracion = entrada.readUTF();

                synchronized (valoraciones) {
                    valoraciones.add(valoracion);
                }
            }
        } catch (IOException e) {
            System.out.println("Error en el Servidor Central: " + e.getMessage());
        }
    }

    private static void imprimirValoraciones(){
        synchronized (valoraciones){
            System.out.println("Valoraciones recibidas: ");
            for (String valoracion : valoraciones){
                System.out.println(valoracion);
            }
            valoraciones.clear();
        }
    }
}
