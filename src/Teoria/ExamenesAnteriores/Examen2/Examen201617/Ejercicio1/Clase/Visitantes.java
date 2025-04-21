package Teoria.ExamenesAnteriores.Examen2.Examen201617.Ejercicio1.Clase;

public class Visitantes extends Thread {
    private int idVisitante;
    private Museo museo;

    public Visitantes(int idVisitante, Museo museo) {
        this.idVisitante = idVisitante;
        this.museo = museo;
    }

    public void run() {
        try {
            int entrada = (int)(Math.random() * 2);
            if (entrada == 0){
                museo.entrar_museo_este(this, idVisitante);
            } else {
                museo.entrar_museo_oeste(this, idVisitante);
            }

            Thread.sleep(5000);
            museo.salir_museo(this, idVisitante);
        } catch (Exception e){}
    }
}
