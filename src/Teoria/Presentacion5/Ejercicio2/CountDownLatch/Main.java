package Teoria.Presentacion5.Ejercicio2.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        Partido partido = new Partido();

        for (int i = 0; i < 11; i++){
            Ninio ninio = new Ninio(i, partido);
            ninio.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
