package Teoria.ExamenesAnteriores.Examen2.Examen201516.Ejercicio1;

public class Semaforo extends Thread {
    private Cruce cruce;

    public Semaforo(Cruce cruce) {
        this.cruce = cruce;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(10000);
                cruce.cambiarSemaforo();
                System.out.println("Cambio de semáforos");
            }
        } catch (InterruptedException e){}
    }
}
