package Laboratorio.Sesion5.Ejercicio3;

public class Tenista extends Thread {
    private int id;
    private PistaTenis pistaTenis;

    public Tenista(int id, PistaTenis pistaTenis) {
        this.id = id;
        this.pistaTenis = pistaTenis;
    }

    public void run() {
        try {
            pistaTenis.entrarPista(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
