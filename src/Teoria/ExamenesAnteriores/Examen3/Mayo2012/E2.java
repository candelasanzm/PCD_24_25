package Teoria.ExamenesAnteriores.Examen3.Mayo2012;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class E2 {
    public static void main(String[] args) {
        try {
            // Abro conexión TCP para la conexión con E1, es el servidor
            ServerSocket servidorE1 = new ServerSocket(5000);
            Socket conexionE1 = servidorE1.accept();
            DataInputStream entrada = new DataInputStream(conexionE1.getInputStream());

            System.out.println("Servidor TCP E2 conectado");

            ArrayList<Integer> numerosTransformados = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                int numero = entrada.readInt();
                System.out.println("E2 recibe desde E1: " + numero);
                numerosTransformados.add(numero * 2);
                numerosTransformados.add(numero / 2);
            }

            entrada.close();
            conexionE1.close();
            servidorE1.close();

            // Abro una coneción TCP para la conexión con E3, es el cliente
            Socket clienteE3 = new Socket(InetAddress.getLocalHost(), 4000);
            DataOutputStream salida = new DataOutputStream(clienteE3.getOutputStream());

            for(int i = 0; i < numerosTransformados.size(); i++){
                salida.writeInt(numerosTransformados.get(i));
            }

            salida.close();
            clienteE3.close();
        } catch (IOException e){
            System.out.println("Error en el equipo E2: " + e.getMessage());
        }
    }
}
