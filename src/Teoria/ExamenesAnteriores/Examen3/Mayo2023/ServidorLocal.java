package Teoria.ExamenesAnteriores.Examen3.Mayo2023;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorLocal {
    public static void main(String[] args) {
        try {
            SistemaValoraciones sistemaValoraciones = new SistemaValoraciones();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("SistemaValoraciones", sistemaValoraciones);

            System.out.println("Servidor Arrancado");
        } catch (IOException e){
            System.out.println("Error en el Servidor: " + e.getMessage());
        }
    }
}
