package Teoria.ExamenesAnteriores.Examen1.PECT1_22_23.examen1;

public class Examen {
    public static void main(String[] args) {
        Edificio edificio = new Edificio();

        for (int i = 1; i <= 10; i++){
            Estudiantes estudiantes = new Estudiantes(i, edificio);
            estudiantes.start();
            try{
                Thread.sleep(500);
            } catch (Exception e){}
        }
    }
}
