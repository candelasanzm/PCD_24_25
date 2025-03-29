package Teoria.Presentacion3.Parte2.Ejercicio4.Forma2;

import java.util.Random;

public class Cliente extends Thread{
    private int id;
    private Tienda tienda;
    private Random random = new Random();

    public Cliente(int id, Tienda tienda) {
        this.id = id;
        this.tienda = tienda;
    }

    public void run() {
        try{
            Thread.sleep(random.nextInt(2000));
            int numPrendas = random.nextInt(6);

            if (numPrendas > 0) {

                if (random.nextBoolean()){
                    tienda.probarRopa(id, numPrendas);
                    tienda.pagar(id, numPrendas);
                    System.out.println("El cliente " + id + " sale de la tienda");
                } else {
                    System.out.println("Cliente " + id + " se va sin comprar nada");
                }

            } else {
                System.out.println("Cliente " + id + " entró pero no compro nada");
            }
        } catch (Exception e){}
    }
}
