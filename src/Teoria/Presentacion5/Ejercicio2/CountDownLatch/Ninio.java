package Teoria.Presentacion5.Ejercicio2.CountDownLatch;

public class Ninio extends Thread {
    private int id;
    private Partido partido;

    public Ninio(int id, Partido partido) {
        this.id = id;
        this.partido = partido;
    }

    public void run() {
        try {
            partido.llegar(id);
            if (id == partido.participantes.get(0)){
                partido.realizarSorteo();
                System.out.println("Niño " + id + " es el árbitro");
                Thread.sleep(5000);
                System.out.println("Árbitro " + id + " pita el partido");
                partido.finalizarPartido();
            } else {
                System.out.println("Niño " + id + " está jugando");
                partido.esperarFinal();
            }
            System.out.println("Niño " + id + " finaliza el partido");
        } catch (Exception e) {}
    }
}
