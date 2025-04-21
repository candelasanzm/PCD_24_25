package Teoria.ExamenesAnteriores.Examen2.Examen201617.Ejercicio2.OtraForma;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera();

        for (int i = 1; i < 3; i++){
            CocheSeguridad cocheSeguridad = new CocheSeguridad(i, carrera);
            cocheSeguridad.start();
        }

        for (int i = 1; i < 21; i++){
            CocheCarreras cocheCarreras = new CocheCarreras(i, carrera);
            cocheCarreras.start();
        }
    }
}
