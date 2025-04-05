package Teoria.Presentacion4.Ejercicio1.Monitores;

public class Cocinero extends Thread{
    private Restaurante restaurante;
    private int id;

    public Cocinero(Restaurante restaurante, int id) {
        this.restaurante = restaurante;
        this.id = id;
    }

    public void run() {
        try {
            while (true) {
                String comanda = restaurante.cogerComanda();
                System.out.println("Cocinero " + id + " coge comanda " + comanda);
                Thread.sleep(400);
                System.out.println("Cocinero " + id + " termina comanda " + comanda);
            }
        } catch (Exception e) {}
    }
}
