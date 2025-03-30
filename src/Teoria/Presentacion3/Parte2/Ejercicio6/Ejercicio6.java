package Teoria.Presentacion3.Parte2.Ejercicio6;

public class Ejercicio6 {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Productor productor = new Productor(1, sistema);
        productor.start();
        for (int i = 1; i < 5; i++) {
            Consumidor consumidor = new Consumidor(i, sistema);
            consumidor.start();
        }
    }
}
