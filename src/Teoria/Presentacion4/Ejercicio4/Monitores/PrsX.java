package Teoria.Presentacion4.Ejercicio4.Monitores;

public class PrsX extends Thread {
    private int id;
    private Sistema sistema;

    public PrsX(int id, Sistema s) {
        this.id = id;
        this.sistema = s;
    }

    public void run() {
        try {
            while (true) {
                int temp = 10 + (int) (Math.random() * 15);
                sistema.escribir(temp, id);
                sleep(1000 + (int) (Math.random() * 1000));
            }
        } catch (Exception e) {}
    }
}
