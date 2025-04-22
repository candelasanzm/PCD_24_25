package Teoria.ExamenesAnteriores.Examen2.Examen202223.Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Examen examen = new Examen();

        Profesor profesor = new Profesor(examen);
        profesor.start();

        for (int i = 1; i < 41; i++){
            Estudiante estudiante = new Estudiante(examen);
            estudiante.start();
        }
    }
}
