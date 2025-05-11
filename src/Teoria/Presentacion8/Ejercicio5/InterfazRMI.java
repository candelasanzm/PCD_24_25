package Teoria.Presentacion8.Ejercicio5;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfazRMI extends Remote {
    void calcularMedias(ArrayList<Integer> temperaturas, ArrayList<Integer> humedades) throws RemoteException;

    void enviarDatos(int temperatura, int humedad) throws RemoteException;
}
