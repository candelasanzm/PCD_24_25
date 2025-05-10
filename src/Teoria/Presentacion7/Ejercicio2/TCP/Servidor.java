package Teoria.Presentacion7.Ejercicio2.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        Socket conexion;
        ServerSocket servidor;
        DataInputStream entrada;
        DataOutputStream salida;

        try {
            servidor = new ServerSocket(5000);
            System.out.println("Servidor conectado");

            while (true) {
                conexion = servidor.accept();
                entrada = new DataInputStream(conexion.getInputStream());
                salida = new DataOutputStream(conexion.getOutputStream());
                int numero = entrada.readInt();
                boolean esPrimo = numeroPrimo(numero);
                salida.writeUTF("¿El número " + numero + " es primo?: " + esPrimo);
                conexion.close();
            }

        } catch (IOException e){}
    }

    private static boolean numeroPrimo(int numero) {
        if(numero <= 1){
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(numero); i++) {
                if (numero % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
