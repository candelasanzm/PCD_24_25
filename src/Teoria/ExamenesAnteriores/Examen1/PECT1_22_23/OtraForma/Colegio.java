package Teoria.ExamenesAnteriores.Examen1.PECT1_22_23.OtraForma;

public class Colegio {
    public static void main(String[] args) {
        Edificio edificio = new Edificio();

        for(int i = 1; i <= 10; i++){
            Estudiantes estudiantes = new Estudiantes(i, (i % 2) + 1, edificio);
            estudiantes.start();
        }
    }
}
