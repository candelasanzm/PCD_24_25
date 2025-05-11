package Teoria.ExamenesAnteriores.Examen3.Julio2014;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;

public class Cliente {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            MeteorologiaRMI meteorologiaRMI = (MeteorologiaRMI) registry.lookup("EstacionesRMI");

            while (true){
                double temperatura = (double)(Math.random() * 39) + 1;
                double velocidadViento = (double)(Math.random() * 100);
                double humedad = (double)(Math.random() * 100);

                LocalDateTime fecha = LocalDateTime.now();

                meteorologiaRMI.registrarDatos(fecha, 1, temperatura, velocidadViento, humedad);

                int espera = (int) (Math.random() * 4000) + 3000;
                Thread.sleep(espera);
            }
        } catch (IOException e){
            System.out.println("Error en el cliente: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
