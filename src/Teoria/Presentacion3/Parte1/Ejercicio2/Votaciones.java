package Teoria.Presentacion3.Parte1.Ejercicio2;

public class Votaciones {
    public static void main(String[] args) {
        SistemaVotacion urna = new SistemaVotacion();
        for (int i = 1; i <= 80; i++) {
            Estudiante estudiante = new Estudiante(urna);
            estudiante.start();
        }
    }
}