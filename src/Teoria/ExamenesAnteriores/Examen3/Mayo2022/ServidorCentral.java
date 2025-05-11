package Teoria.ExamenesAnteriores.Examen3.Mayo2022;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorCentral {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1100);

            AccionesServicioRMI accionesServicioRMI = new AccionesServicioRMI();
            registry.rebind("ServidorCentral", accionesServicioRMI);

            System.out.println("Servidor Central Arrancado");
        } catch (IOException e){
            System.out.println("Error en el Servidor Central: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Error en el Servidor Central: " + e.getMessage());
        }
    }
}
