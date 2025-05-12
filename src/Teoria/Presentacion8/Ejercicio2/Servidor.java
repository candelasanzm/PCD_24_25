package Teoria.Presentacion8.Ejercicio2;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) throws RemoteException {
        try {
            CalcularEdadRMI calcularEdadRMI = new CalcularEdadRMI();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("//127.0.0.1/CalculadoraEdadRMI", calcularEdadRMI);
            System.out.println("Servidor RMI conectado");
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
