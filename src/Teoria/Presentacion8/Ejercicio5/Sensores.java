package Teoria.Presentacion8.Ejercicio5;

import java.io.IOException;
import java.rmi.Naming;

public class Sensores {
    public static void main(String[] args) {
        try {
            InterfazRMI interfazRMI = (InterfazRMI) Naming.lookup("//127.0.0.1/OperacionesRMI");

            while(true){
                int temperatura = (int)(Math.random() * 50) + 1;
                int humedad = (int)(Math.random() * 100) + 1;

                interfazRMI.enviarDatos(temperatura, humedad);
                System.out.println("Sensor envió: temperatura = " + temperatura + ", humedad = " + humedad);

                Thread.sleep((int)(Math.random() * 1) + 1);
            }
        } catch (IOException e){
            System.out.println("Error en el sensor: " + e.getMessage());
        } catch (InterruptedException e){
            System.out.println("Error en el sensor: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Error en el sensor: " + e.getMessage());
        }
    }
}
