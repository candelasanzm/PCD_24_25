package Teoria.Presentacion8.Ejercicio3;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Servidor {
    public static void main(String[] args) {
        try {
            RealizarSorteoRMI realizarSorteoRMI = new RealizarSorteoRMI();


            Naming.rebind("//127.0.0.1/RealizarSorteoRMI", realizarSorteoRMI);

            System.out.println("Servidor agregado exitosamente");
        } catch (RemoteException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
