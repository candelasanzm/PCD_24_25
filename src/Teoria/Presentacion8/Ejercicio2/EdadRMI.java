package Teoria.Presentacion8.Ejercicio2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

public interface EdadRMI extends Remote {
    int calcularEdad(LocalDate fechaDeNacimiento) throws RemoteException;
}
