package Teoria.ExamenesAnteriores.Examen3.Julio2014;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

public class EstacionesRMI extends UnicastRemoteObject implements MeteorologiaRMI {
    public EstacionesRMI() throws RemoteException {}

    @Override
    public void registrarDatos(LocalDateTime fecha, int idEstacion, double temperatura, double velocidadViento, double humedad) throws RemoteException{
        System.out.println("Fecha: " + fecha + ". IdEstación: " + idEstacion + ". Temperatura: " + temperatura + ". Velocidad Viento: " + velocidadViento + ". Humedad: " + humedad);
    }
}
