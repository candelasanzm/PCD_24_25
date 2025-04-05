package Teoria.Presentacion4.Ejercicio1.Monitores;

public class Camarero extends Thread{
    private int id;
    private Restaurante restaurante;

    public Camarero(int id, Restaurante restaurante) {
        this.id = id;
        this.restaurante = restaurante;
    }

    public void run(){
        try {
            while(true){
                String comanda = "Comanda " + id + "-" + System.currentTimeMillis();
                restaurante.dejarComanda(comanda);
                System.out.println("Camarero " + id + " dejó: " + comanda);
                Thread.sleep(500);
            }
        } catch (Exception e) {}
    }
}
