package Teoria.Presentacion4.Ejercicio9;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        // Crear sensores
        PrsX sensor1 = new PrsX(1, sistema);
        PrsX sensor2 = new PrsX(2, sistema);
        PrsX sensor3 = new PrsX(3, sistema);

        // Crear display
        PrD display = new PrD(sistema);

        // Iniciar hilos
        sensor1.start();
        sensor2.start();
        sensor3.start();
        display.start();
    }
}
