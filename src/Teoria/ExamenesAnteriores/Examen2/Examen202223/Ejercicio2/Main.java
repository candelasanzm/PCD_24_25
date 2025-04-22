package Teoria.ExamenesAnteriores.Examen2.Examen202223.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        Cafeteria cafeteria = new Cafeteria();

        for (int i = 1; i < 301; i++){
            Persona persona = new Persona(i, cafeteria);
            persona.start();
        }
    }
}
