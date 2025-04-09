package Teoria.Presentacion4.Ejercicio8.Semaforos;

public class Ninio extends Thread{
    private int id;
    private Jugar jugar;

    public Ninio(int id, Jugar jugar) {
        this.id = id;
        this.jugar = jugar;
    }

    public void run() {
        try{
            System.out.println("Niño " + id + " juega");
            Thread.sleep(25 * 1000);
            jugar.montar(id);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Niño " + id + " se va del parque");
    }
}
