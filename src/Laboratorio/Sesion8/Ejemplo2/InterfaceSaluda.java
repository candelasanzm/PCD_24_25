package Laboratorio.Sesion8.Ejemplo2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceSaluda extends Remote
{
    String saludar(String nombre) throws RemoteException;
    String decirAdios(String nombre) throws RemoteException;
}
