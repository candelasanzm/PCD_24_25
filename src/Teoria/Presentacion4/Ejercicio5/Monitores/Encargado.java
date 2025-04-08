package Teoria.Presentacion4.Ejercicio5.Monitores;

public class Encargado extends Thread {
    private Urna urna;

    public Encargado(Urna urna) {
        this.urna = urna;
    }

    public void run() {
        try {
            while (urna.vaciarUrna()){
                Thread.sleep(500);
            }
            urna.ganador();
        } catch (Exception e){}
    }
}
