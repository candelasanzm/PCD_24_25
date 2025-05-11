package Teoria.ExamenesAnteriores.Examen3.Mayo2022;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AccionesServicioRMI extends UnicastRemoteObject implements ServidoresRMI {
    public AccionesServicioRMI() throws RemoteException {}

    public void guardarEstado(String ipModulo, int idSensor, int valor) throws RemoteException {
        System.out.println("Estado almacenado en " + ipModulo + " - Sensor: " + idSensor + " - Valor: " + valor);
    }

    public void llamarBomberos(String ipModulo) throws RemoteException{
        System.out.println("Incendio detectado en " + ipModulo + ". Llamando a los bomberos.");
    }
}
