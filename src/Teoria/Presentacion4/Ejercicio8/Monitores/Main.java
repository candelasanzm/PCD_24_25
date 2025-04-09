package Teoria.Presentacion4.Ejercicio8.Monitores;

public class Main {
    public static void main(String[] args) {
        Jugar jugar = new Jugar();

        for (int i = 0; i < 30; i++){
            Ninio ninio = new Ninio(i + 1, jugar);
            ninio.start();
        }
    }
}
