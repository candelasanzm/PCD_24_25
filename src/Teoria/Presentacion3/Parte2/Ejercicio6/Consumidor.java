package Teoria.Presentacion3.Parte2.Ejercicio6;

public class Consumidor extends Thread{
    private int id;
    private Sistema sistema;

    public Consumidor(int id, Sistema s) {
        this.id = id;
        this.sistema = s;
    }

    public void run() {
        try{
            while(true){
                int tiempo = (int)(Math.random() * 1) + 1;
                Thread.sleep(tiempo);
                int[] muestra = sistema.leer();
                System.out.println("Consumidor " + id + " obtiene la muestra " + java.util.Arrays.toString(muestra));
            }
        } catch (Exception e){}
    }
}
