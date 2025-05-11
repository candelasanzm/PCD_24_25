package Teoria.ExamenesAnteriores.Examen3.Julio2014;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            EstacionesRMI estacionesRMI = new EstacionesRMI();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("//127.0.0.1/EstacionesRMI", estacionesRMI);

            System.out.println("Servidor Arrancado");
        } catch (IOException e){
            System.out.println("Error en el Servidor: " + e.getMessage());
        }
    }
}
