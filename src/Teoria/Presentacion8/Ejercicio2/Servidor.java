package Teoria.Presentacion8.Ejercicio2;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class Servidor {
    public static void main(String[] args) throws RemoteException {
        try {
            CalcularEdadRMI calcularEdadRMI = new CalcularEdadRMI();

            Naming.rebind("//127.0.0.1/CalculadoraEdadRMI", calcularEdadRMI);
            System.out.println("Servidor RMI conectado");
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
