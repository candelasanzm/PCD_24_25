package Teoria.ExamenesAnteriores.Examen2.Examen201516.Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Campo campo = new Campo();

        for (int i = 1; i < 28; i++){
            try {
                Jugador jugador = new Jugador(i, campo);
                jugador.start();
                Thread.sleep(500);
            } catch (Exception e){}
        }
    }
}
