package Teoria.Presentacion8.Ejercicio3;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface SorteoRMI extends Remote {
    ArrayList<Integer> getSorteo(String sorteo) throws RemoteException;

    boolean comprobarSorteo(String sorteo, ArrayList<Integer> combinacion) throws RemoteException;

    void nuevoSorteo(String sorteo, ArrayList<Integer> combinacion) throws RemoteException;
}
