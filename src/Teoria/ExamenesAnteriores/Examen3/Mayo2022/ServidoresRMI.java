package Teoria.ExamenesAnteriores.Examen3.Mayo2022;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServidoresRMI extends Remote {
    void guardarEstado(String ipModulo, int idSensor, int valor) throws RemoteException;

    void llamarBomberos(String ipModulo) throws RemoteException;
}
