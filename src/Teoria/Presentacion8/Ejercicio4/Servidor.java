package Teoria.Presentacion8.Ejercicio4;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServicioSupermercadoRMI servicioSupermercadoRMI = new ServicioSupermercadoRMI();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("//127.0.0.1/ServicioSupermercadoRMI", servicioSupermercadoRMI);
            System.out.println("Servidor Arrandado");

        } catch (IOException e){
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
