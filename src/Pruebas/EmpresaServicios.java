package Pruebas;

public class EmpresaServicios {
    public static void main(String[] args) {
        Edificio edificio = new Edificio();

        for (int i = 0; i < 50; i++){
            Trabajador t = new Trabajador (i, edificio);
            t.start();
        }
    }
}
