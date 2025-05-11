package Teoria.Presentacion8.Ejercicio4;

import java.io.IOException;
import java.rmi.Naming;

public class Cliente {
    public static void main(String[] args) {
        try {
            SupermercadoRMI supermercadoRMI = (SupermercadoRMI) Naming.lookup("//127.0.0.1/ServicioSupermercadoRMI");

            int idEmpleado = (int)(Math.random() * 999) + 1;

            for (int i = 0; i < 10; i++){
                int cantidadProductos = (int)(Math.random() * 999) + 1;
                int precioTotal = (int)(Math.random() * 999) + 1;

                System.out.println("Procesando pedido: " + i);
                System.out.println(supermercadoRMI.procesarPedido(idEmpleado, cantidadProductos, precioTotal));
            }
        } catch (IOException e){
            System.out.println("Error en el cliente: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
