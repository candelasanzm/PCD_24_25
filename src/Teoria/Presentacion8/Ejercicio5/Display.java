package Teoria.Presentacion8.Ejercicio5;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Display {
    public static void main(String[] args) {
        try {
            OperacionesRMI operacionesRMI = new OperacionesRMI();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("//127.0.0.1/OperacionesRMI", operacionesRMI);

            System.out.println("Display Arrancado");
        } catch (IOException e){
            System.out.println("Error en el display; " + e.getMessage());
        }
    }
}
