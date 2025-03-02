package Teoria.ExamenesAnteriores.Examen1.PECT1_22_23.Profe;

import static java.lang.Thread.sleep;

public class Inicializar {
    public static void main(String[] args) {
        Escuela escuela = new Escuela();

        try{
            for (int i = 1; i <= 100; i++){
                Estudiantes estudiantes = new Estudiantes(i, ((i % 2) + 1 ), escuela);
                estudiantes.start();
                sleep(500);
            }
        } catch (Exception e){}
    }
}
