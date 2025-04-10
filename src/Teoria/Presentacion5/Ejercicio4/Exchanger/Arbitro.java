package Teoria.Presentacion5.Ejercicio4.Exchanger;

public class Arbitro extends Thread {
    private Urna urna;

    public Arbitro(Urna urna) {
        this.urna = urna;
    }

    public void run() {
        while(!urna.isVotacionTerminada()) {
            urna.realizarRecuentoParcial();
        }
        urna.calcularGanador();
    }
}
