package Teoria.ExamenesAnteriores.Examen2.Examen201516.Ejercicio1;

public class Coche extends  Thread {
    private int id;
    private boolean vieneDelOeste;
    private Cruce cruce;

    public Coche(int id, boolean vieneDelOeste, Cruce cruce) {
        this.id = id;
        this.vieneDelOeste = vieneDelOeste;
        this.cruce = cruce;
    }

    public void run() {
        try {
            cruce.esperarSemaforo(vieneDelOeste);
            System.out.println("Coche " + id + " cruza desde " + (vieneDelOeste ? "Oeste" : "Norte"));
            Thread.sleep((int)(Math.random() * 3000) + 2000);
            cruce.salirCruce();
        } catch (InterruptedException e){}
    }
}
