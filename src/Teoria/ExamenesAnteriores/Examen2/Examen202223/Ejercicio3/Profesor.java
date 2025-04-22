package Teoria.ExamenesAnteriores.Examen2.Examen202223.Ejercicio3;

public class Profesor extends Thread {
    private Examen examen;

    public Profesor(Examen examen) {
        this.examen = examen;
    }

    public void run() {
        try {
            Thread.sleep(2000);
            examen.esperarInicio();
            examen.realizarExamen();
        } catch (Exception e){}
    }
}
