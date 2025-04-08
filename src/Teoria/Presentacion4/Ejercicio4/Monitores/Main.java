package Teoria.Presentacion4.Ejercicio4.Monitores;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        PrsX sensor1 = new PrsX(1, sistema);
        PrsX sensor2 = new PrsX(2, sistema);
        PrsX sensor3 = new PrsX(3, sistema);

        PrD display = new PrD(sistema);

        sensor1.start();
        sensor2.start();
        sensor3.start();
        display.start();
    }
}
