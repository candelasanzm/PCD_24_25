package Teoria.Presentacion3.Parte2.Ejercicio6;

public class Productor extends Thread{
    private Sistema sistema;

    public Productor(int id, Sistema s) {
        this.sistema = s;
    }

    public void run() {
        try {
            while (true) {
                int tiempo = (int)(Math.random() * 4) + 1;
                Thread.sleep(tiempo);
                sistema.escribir();
            }
        } catch (Exception e){}
    }
}
