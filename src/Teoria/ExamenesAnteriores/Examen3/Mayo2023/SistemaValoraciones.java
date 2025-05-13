package Teoria.ExamenesAnteriores.Examen3.Mayo2023;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SistemaValoraciones extends UnicastRemoteObject implements Valoraciones {
    public SistemaValoraciones() throws RemoteException{}

    public boolean enviarValoracion(int puntuacion, String comentario, String ipCliente, int idTransaccion) throws RemoteException{
        if(puntuacion < 0 || puntuacion > 5){
            return false;
        }

        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 5000);
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            String mensaje = ipCliente + ":" + puntuacion + ":" + comentario + ":" + idTransaccion;
            salida.writeUTF(mensaje);

            salida.close();
            socket.close();
            return true;
        } catch (IOException e) {
            System.out.println("Error al enviar la valoración: " + e.getMessage());
            return false;
        }
    }
}
