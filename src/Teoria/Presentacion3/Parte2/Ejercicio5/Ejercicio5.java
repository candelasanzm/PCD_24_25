package Teoria.Presentacion3.Parte2.Ejercicio5;

public class Ejercicio5 {
    public static void main(String[] args) {
        Jugar jugar = new Jugar();

        for (int i = 0; i < 30; i++){
            Ninio ninio = new Ninio(i + 1, jugar);
            ninio.start();
        }
    }
}
