package Laboratorio.Sesion5.Ejercicio3;

public class Main {
    public static void main(String[] args) {
        PistaTenis p = new PistaTenis();

        for (int i = 0; i < 12; i++) {
            Tenista tenista = new Tenista(i, p);
            tenista.start();
        }
    }
}
