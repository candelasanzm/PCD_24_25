package Teoria.Presentacion8.Ejercicio1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraRMI extends UnicastRemoteObject implements OperacionesRMI {
    public CalculadoraRMI() throws RemoteException {}

    public int multiplicar(int a, int b) throws RemoteException {
        return a * b;
    }

    public double potencia(int base, int exponente) throws RemoteException {
        return Math.pow(base, exponente);
    }
}
