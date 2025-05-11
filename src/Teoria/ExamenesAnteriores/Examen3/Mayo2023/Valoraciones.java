package Teoria.ExamenesAnteriores.Examen3.Mayo2023;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Valoraciones extends Remote {
    boolean enviarValoracion(int puntuacion, String comentario, String ipCliente, int idTransaccion) throws RemoteException;
}
