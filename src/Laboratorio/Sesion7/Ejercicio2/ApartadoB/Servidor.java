package Laboratorio.Sesion7.Ejercicio2.ApartadoB;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor
{
    public static void main(String args[])
    {
        ServerSocket servidor;
        Socket conexion;
        DataOutputStream salida;
        DataInputStream entrada;
        int num = 0;
        try
        {
            servidor = new ServerSocket(5000); // Creamos un ServerSocket en el puerto 5000
            System.out.println("Servidor Arrancado....");
            // Como se trata de un while true no es necesario hacer nada
            while (true)
            {
                conexion = servidor.accept();     // Esperamos una conexión
                num++;
                System.out.println("Conexión nº " + num + " desde: " + conexion.getInetAddress().getHostName());


                entrada = new DataInputStream(conexion.getInputStream());  // Abrimos los canales de E/S
                salida  = new DataOutputStream(conexion.getOutputStream());
                String mensaje = entrada.readUTF();    //Leemos el mensaje del cliente


                System.out.println("Conexión nº " + num + ". Mensaje recibido: " + mensaje);
                salida.writeUTF("Buenos dias " + mensaje);  // Le respondemos
                conexion.close();                           // Y cerramos la conexión
            }
        } catch (IOException e) {}
    }
}
