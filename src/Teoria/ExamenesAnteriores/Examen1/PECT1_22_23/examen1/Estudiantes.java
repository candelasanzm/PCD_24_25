package Teoria.ExamenesAnteriores.Examen1.PECT1_22_23.examen1;

public class Estudiantes extends Thread{
    private int estudiantesID;
    private int numAula;
    private Edificio edificio;

    public Estudiantes(int estudiantesID, Edificio edificio){
        this.estudiantesID = estudiantesID;
        this.numAula = 1 + (int)(Math.random() * 2);
        this.edificio = edificio;
    }

    public void run(){
        //Los estudiantes entran en las aulas
        edificio.accesoAulas(estudiantesID, numAula, true);

        //Estudiar
        try {
            Thread.sleep(30 * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        //Salir de las aulas
        edificio.accesoAulas(estudiantesID, numAula, false);

        //Descanso
        int eleccion = 1 + (int)(Math.random() * 2);
        switch(eleccion){
            case 1 -> edificio.usarMaquina(estudiantesID);
            case 2 -> edificio.usarBanio(estudiantesID);
        }

        //Volver al aula
        edificio.accesoAulas(estudiantesID, numAula, true);

        //Estudiar
        try {
            Thread.sleep(30 * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        //Ir a casa
        edificio.accesoAulas(estudiantesID, numAula, false);
    }
}
