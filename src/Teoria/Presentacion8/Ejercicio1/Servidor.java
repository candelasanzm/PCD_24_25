package Teoria.Presentacion8.Ejercicio1;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            CalculadoraRMI calc = new CalculadoraRMI();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("//127.0.0.1/CalculadoraRMI", calc);
            System.out.println("Servidor creado con exito");
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
