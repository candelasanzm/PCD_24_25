package Teoria.Presentacion8.Ejercicio1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;

public class Cliente {
    public static void main(String[] args) {
        String respuesta = "";
        try {
            OperacionesRMI operacionesRMI = (OperacionesRMI) Naming.lookup("//127.0.0.1/CalculadoraRMI");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Introduzca el primer número: ");
            int numero1 = Integer.parseInt(entrada.readLine());

            System.out.println("Introduzca el segundo número: ");
            int numero2 = Integer.parseInt(entrada.readLine());

            int multiplicacion = operacionesRMI.multiplicar(numero1, numero2);
            double resultadoPotencia = operacionesRMI.potencia(numero1, numero2);

            System.out.println("\nMultiplicación ( " + numero1 + " * " + numero2 + " ) = " + multiplicacion);
            System.out.println("\nPotencia (" + numero1 + " ^ " + numero2 + ") = " + resultadoPotencia);
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
