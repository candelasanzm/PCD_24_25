package Teoria.ExamenesAnteriores.Examen2.Examen201617.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera();

        for (int i = 0; i < 23; i++){
            CocheC cocheC = new CocheC(carrera);
            CocheS cocheS = new CocheS(carrera);
            cocheC.start();
            cocheS.start();
        }
    }
}
