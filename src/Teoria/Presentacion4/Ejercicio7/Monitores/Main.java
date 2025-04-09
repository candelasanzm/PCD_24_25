package Teoria.Presentacion4.Ejercicio7.Monitores;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();

        for (int i = 0; i < 50; i++) {
            Trabajador trabajador = new Trabajador(i, empresa);
            trabajador.start();
        }
    }
}
