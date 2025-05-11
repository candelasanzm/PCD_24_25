package Teoria.Presentacion8.Ejercicio2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.Period;

public class CalcularEdadRMI extends UnicastRemoteObject implements EdadRMI {
    public CalcularEdadRMI() throws RemoteException {}

    public int calcularEdad(LocalDate fechaDeNacimiento) throws RemoteException {
        return Period.between(fechaDeNacimiento, LocalDate.now()).getYears();
    }
}
