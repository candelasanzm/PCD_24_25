package Teoria.Presentacion4.Ejercicio5.Monitores;

public class Main {
    public static void main(String[] args) {
        Urna urna = new Urna(40);
        Encargado encargado = new Encargado(urna);
        encargado.start();

        for(int i = 0; i < 80; i++){
            Estudiante estudiante = new Estudiante(i + 1, urna);
            estudiante.start();
        }
    }
}
