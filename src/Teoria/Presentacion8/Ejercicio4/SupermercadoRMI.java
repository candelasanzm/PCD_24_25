package Teoria.Presentacion8.Ejercicio4;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SupermercadoRMI extends Remote {
    int procesarPedido(int idTrabajador, int cantidadProductos, int precioTotal) throws RemoteException;
}
