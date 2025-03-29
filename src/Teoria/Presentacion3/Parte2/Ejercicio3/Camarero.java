package Teoria.Presentacion3.Parte2.Ejercicio3;

public class Camarero extends Thread{
    private int id;
    private Restaurante restaurante;

    public Camarero(int id, Restaurante restaurante) {
        this.id = id;
        this.restaurante = restaurante;
    }

    public void run() {
        try{
            while (true) {
                String comanda = "Comanda " + id + "-" + System.currentTimeMillis();
                restaurante.dejarComanda(comanda);
                System.out.println("Camarero " + id + " dejó: " + comanda);
                Thread.sleep(500);
            }
        } catch (Exception e){}
    }
}
