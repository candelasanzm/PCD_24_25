package Teoria.ExamenesAnteriores.Examen3.Mayo2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            Valoraciones valoraciones = (Valoraciones) registry.lookup("//127.0.0.1/SistemaValoraciones");

            String respuesta = valoraciones.enviarValoracion();
            System.out.println(respuesta);
        } catch (IOException e){
            System.out.println("Error en el Cliente: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Error en el Cliente: " + e.getMessage());
        }
    }
}
