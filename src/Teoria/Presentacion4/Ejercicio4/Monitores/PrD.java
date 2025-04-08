package Teoria.Presentacion4.Ejercicio4.Monitores;

public class PrD extends Thread {
    private Sistema sistema;

    public PrD(Sistema s) {
        this.sistema = s;
    }

    public void run() {
        try {
            while (true) {
                sistema.media();
                sleep(3000 + (int) (Math.random() * 1000));
            }
        } catch (Exception e) {}
    }
}
