package Teoria.ExamenesAnteriores.Examen2.Examen201617.Ejercicio1.Clase;

public class Main {
    public static void main(String[] args) {
        Museo museo = new Museo();

        for (int i = 0; i < 100; i++) {
            Visitantes visitantes = new Visitantes(i, museo);
            visitantes.start();
        }
    }
}
