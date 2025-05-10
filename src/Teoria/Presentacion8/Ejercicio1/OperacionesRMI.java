package Teoria.Presentacion8.Ejercicio1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OperacionesRMI extends Remote {
    int multiplicar(int a, int b) throws RemoteException;
    double potencia(int base, int exponente) throws RemoteException;
}
