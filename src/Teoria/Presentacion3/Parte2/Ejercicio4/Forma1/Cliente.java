package Teoria.Presentacion3.Parte2.Ejercicio4.Forma1;

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
        try{
            Thread.sleep(random.nextInt(2) * 1000);
            int numPrendas = random.nextInt(6);
            if (numPrendas > 0) {
                int probador = tienda.entrarProbador(id, numPrendas);
                for (int i = 0; i < numPrendas; i++) {
                    Thread.sleep(2000);
                }
                tienda.salirProbador(id, probador);

                if (random.nextBoolean()){
                    tienda.pagar(id, numPrendas);
                    Thread.sleep(numPrendas * 1000);
                    tienda.terminarPago(id);
                } else {
                    System.out.println("Cliente " + id + " se va sin comprar nada");
                }
            } else {
                System.out.println("Cliente " + id + " entró pero no compro nada");
            }
        } catch (Exception e){}
    }
}
