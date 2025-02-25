package Teoria.Presentacion3.Parte1.Ejercicio4;

public class EmpresaServicios {
    public static void main(String[] args) {
        Edificio edificio = new Edificio();
        for (int i = 0; i < 50; i++) {
            Trabajador trabajador = new Trabajador(i, edificio);
            trabajador.start();
        }
    }
}
