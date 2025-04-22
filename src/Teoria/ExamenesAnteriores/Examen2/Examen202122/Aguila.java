package Teoria.ExamenesAnteriores.Examen2.Examen202122;

public class Aguila extends Thread {
    private Comedero comedero;

    public Aguila(Comedero comedero) {
        this.comedero = comedero;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(25000);
                comedero.entrarAguila();
            }
        } catch (InterruptedException e){}
    }
}
