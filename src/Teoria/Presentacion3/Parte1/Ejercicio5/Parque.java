package Teoria.Presentacion3.Parte1.Ejercicio5;

public class Parque {
    public static void main(String[] args) {
        Jugar jugar = new Jugar();
        for (int i = 0; i < 20; i++) {
            Ninio ninio = new Ninio(i, jugar);
            ninio.start();
        }
    }
}
