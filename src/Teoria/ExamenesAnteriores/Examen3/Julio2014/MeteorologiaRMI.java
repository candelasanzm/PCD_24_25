package Teoria.ExamenesAnteriores.Examen3.Julio2014;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

public interface MeteorologiaRMI extends Remote {
    void registrarDatos(LocalDateTime fecha, int idEstacion, double temperatura, double velocidadViento, double humedad) throws RemoteException;
}
