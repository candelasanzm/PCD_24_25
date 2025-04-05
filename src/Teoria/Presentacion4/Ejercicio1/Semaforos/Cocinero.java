package Teoria.Presentacion4.Ejercicio1.Semaforos;

public class Cocinero extends Thread{
    private int id;
    private Restaurante restaurante;

    public Cocinero(int id, Restaurante restaurante) {
        this.id = id;
        this.restaurante = restaurante;
    }

    public void run() {
        try {
            while(true) {
                String comanda = restaurante.cogerComanda();
                System.out.println("Cocinero " + id + " coge comanda " + comanda);
                Thread.sleep(400);
                System.out.println("Cocinero " + id + " termina comanda " + comanda);
            }
        } catch (Exception e) {}
    }
}
