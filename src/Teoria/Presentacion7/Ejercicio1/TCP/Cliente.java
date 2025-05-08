package Teoria.Presentacion7.Ejercicio1.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Socket conexion;
        DataOutputStream salida;
        DataInputStream entrada;

        try {
            conexion = new Socket("localhost", 5000);
            salida = new DataOutputStream(conexion.getOutputStream());
            entrada = new DataInputStream(conexion.getInputStream());
            Scanner teclado = new Scanner(System.in);
            System.out.println("Introduce tu fecha de nacimiento (YYYY-MM-DD): " );
            String fecha = teclado.nextLine();
            teclado.close();
            salida.writeUTF(fecha);
            String respuesta = entrada.readUTF();
            System.out.println(respuesta);
            conexion.close();
        } catch (IOException e){}
    }
}
