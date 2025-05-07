package Laboratorio.Sesion7.Ejercicio2.ApartadoC;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor
{
    public static void main(String args[])
    {
        ServerSocket servidor;
        Socket conexion;
        ManejadorCliente manejadorCliente;

        try
        {
            servidor = new ServerSocket(5000); // Creamos un ServerSocket en el puerto 5000
            System.out.println("Servidor Multihilo Arrancado....");
            while (true)
            {
                conexion = servidor.accept();
                System.out.println("Nuevo cliente conectado: " + conexion.getInetAddress().getHostName());
                manejadorCliente = new ManejadorCliente(conexion);
                manejadorCliente.start();
            }
        } catch (IOException e) {}
    }
}
