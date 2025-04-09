package Teoria.Presentacion4.Ejercicio10;

public class Main {
    public static void main(String[] args) {
        Urna urna = new Urna();

        for(int i = 0; i < 80; i++){
            Estudiante estudiante = new Estudiante(i + 1, urna);
            estudiante.start();
        }
    }
}
