package Teoria.Presentacion7.Ejercicio2.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Socket conexion;
        DataInputStream entrada;
        DataOutputStream salida;

        try {
            conexion = new Socket("localhost", 5000);
            entrada = new DataInputStream(conexion.getInputStream());
            salida = new DataOutputStream(conexion.getOutputStream());
            Scanner numeroPorTeclado = new Scanner(System.in);
            System.out.println("Introduce un número entero positivo mayor que 1: ");
            int numero = numeroPorTeclado.nextInt();
            numeroPorTeclado.close();
            salida.writeInt(numero);
            String respuesta = entrada.readUTF();
            System.out.println(respuesta);
            conexion.close();
        } catch (IOException e){}
    }
}
