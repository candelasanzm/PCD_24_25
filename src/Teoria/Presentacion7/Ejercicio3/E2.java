package Teoria.Presentacion7.Ejercicio3;

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
            ServerSocket servidorE1 = new ServerSocket(5000);
            System.out.println("E2 esperando datos de E1");
            Socket conexion_E1_E2 = servidorE1.accept();
            DataInputStream entrada = new DataInputStream(conexion_E1_E2.getInputStream());

            ArrayList<Integer> numerosTransformados = new ArrayList<>();
            for (int i = 0; i < 5; i++){
                int numero = entrada.readInt();
                System.out.println("E2 ha recibido desde E1: " + numero);
                numerosTransformados.add(numero * 2);
                numerosTransformados.add(numero / 2);
            }

            entrada.close();
            conexion_E1_E2.close();
            servidorE1.close();

            Socket clienteE3 = new Socket(InetAddress.getLocalHost(), 3000);
            DataOutputStream salida = new DataOutputStream(clienteE3.getOutputStream());

            for (int i = 0; i < numerosTransformados.size(); i++){
                salida.writeInt(numerosTransformados.get(i));
            }

            salida.close();
            clienteE3.close();

        } catch (IOException e){
            System.out.println("Error en el equipo E2: " + e.getMessage());
        }
    }
}
