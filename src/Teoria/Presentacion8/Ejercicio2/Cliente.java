package Teoria.Presentacion8.Ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Cliente {
    public static void main(String[] args) throws IOException {
        try {
            EdadRMI edadRMI = (EdadRMI) Naming.lookup("//127.0.0.1/CalculadoraEdadRMI");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Introduce tu fecha de nacimiento (YYYY-MM-DD): ");
            String fecha = entrada.readLine();

            LocalDate fechaNacimiento;
            try {
                fechaNacimiento = LocalDate.parse(fecha);
            } catch (Exception e) {
                System.out.println("Formato de fecha no válido");
                return ;
            }

            int edad = edadRMI.calcularEdad(fechaNacimiento);
            System.out.println("\nTu edad es: " + edad);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
