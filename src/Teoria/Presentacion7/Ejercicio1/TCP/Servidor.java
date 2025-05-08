package Teoria.Presentacion7.Ejercicio1.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.Period;

public class Servidor {
    public static void main(String[] args) {
        ServerSocket servidor;
        Socket conexion;
        DataOutputStream salida;
        DataInputStream entrada;

        try {
            servidor = new ServerSocket(5000);
            System.out.println("Servidor conectado");

            while (true) {
                conexion = servidor.accept();
                entrada = new DataInputStream(conexion.getInputStream());
                salida = new DataOutputStream(conexion.getOutputStream());
                String fechaDeNacimiento = entrada.readUTF();
                int edad = calcularEdad(fechaDeNacimiento);
                salida.writeUTF("Edad: " + edad);
                conexion.close();
            }
        } catch (IOException e) {}
    }

    private static int calcularEdad(String fechaDeNacimiento) {
        LocalDate nacimiento = LocalDate.parse(fechaDeNacimiento);
        LocalDate fecha = LocalDate.now();
        return Period.between(nacimiento, fecha).getYears();
    }
}
