package Teoria.ExamenesAnteriores.Examen3.Mayo2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.rmi.Naming;

public class Cliente {
    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Introduce la puntuación: ");
            int puntuacion = Integer.parseInt(entrada.readLine());
            System.out.println("Introduce el comentario: ");
            String comentario = entrada.readLine();
            String ipCliente = InetAddress.getLocalHost().getHostAddress();
            System.out.println("Introduce el id de la transacción: ");
            int idTransaccion = Integer.parseInt(entrada.readLine());

            Valoraciones valoraciones = (Valoraciones) Naming.lookup("//127.0.0.1/SistemaValoraciones");

            boolean isValido = valoraciones.enviarValoracion(puntuacion, comentario, ipCliente, idTransaccion);

            if (isValido){
                String respuesta = "Puntuación: " + puntuacion + ". Comentario: " + comentario + ". IpCliente: " + ipCliente + ". IdTransaccion: " + idTransaccion;
                System.out.println(respuesta);
            }
        } catch (IOException e){
            System.out.println("Error en el Cliente: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Error en el Cliente: " + e.getMessage());
        }
    }
}
