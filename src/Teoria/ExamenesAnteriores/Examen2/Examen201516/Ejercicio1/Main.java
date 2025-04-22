package Teoria.ExamenesAnteriores.Examen2.Examen201516.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Cruce cruce = new Cruce();

        Semaforo semaforo = new Semaforo(cruce);
        semaforo.start();

        for(int i = 0; i < 40; i++){
            boolean vieneDelOeste = (i % 2 == 0);
            Coche coche = new Coche(i, vieneDelOeste, cruce);
            coche.start();
        }
    }
}
