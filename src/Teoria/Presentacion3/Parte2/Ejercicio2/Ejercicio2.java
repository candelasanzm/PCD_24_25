package Teoria.Presentacion3.Parte2.Ejercicio2;

public class Ejercicio2 {
    public static void main(String[] args) {
        int numEstudiantes = 80;
        Urna urna = new Urna();

        for (int i = 0; i < numEstudiantes; i++) {
            Estudiante estudiante = new Estudiante(i + 1, urna);
            estudiante.start();
        }
    }
}
