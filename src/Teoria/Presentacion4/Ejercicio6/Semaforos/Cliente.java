package Teoria.Presentacion4.Ejercicio6.Semaforos;

import java.util.Random;

public class Cliente extends Thread {
    private int id;
    private Tienda tienda;
    private Random random = new Random();

    public Cliente(int id, Tienda tienda) {
        this.id = id;
        this.tienda = tienda;
    }

    public void run() {
        try {
            Thread.sleep(random.nextInt(2) * 1000);
            int numPrendas = random.nextInt(6);
            System.out.println("Cliente " + id + " coge " + numPrendas + " prendas");
            if (numPrendas > 0){
                tienda.entrarProbador(id, numPrendas);

                if(random.nextBoolean()){
                    tienda.pagar(id, numPrendas);
                } else {
                    System.out.println("Cliente "+ id + " se va sin comprar nada");
                }
            } else {
                System.out.println("Cliente " + id + " entró pero no compró nada");
            }
        } catch (Exception e) {}
    }
}
