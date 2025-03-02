package Teoria.ExamenesAnteriores.Examen1.PECT1_22_23.Yo;

public class Estudiantes extends Thread{
    private int estudianteID;
    private int numAula;
    Edificio edificio;

    public Estudiantes(int estudianteID, int numAula, Edificio edificio) {
        this.estudianteID = estudianteID;
        this.numAula = numAula;
        this.edificio = edificio;
    }

    public void run(){
        edificio.llegar(estudianteID);
        edificio.aula(estudianteID, numAula, true);
        try{
            sleep(30 * 1000);
        } catch(InterruptedException e){}
        edificio.aula(estudianteID, numAula, false);
        int eleccion = (int) (Math.random() * 3);
        System.out.println("Eleccion: " + eleccion);
        switch (eleccion){
            case 0:
                edificio.usarMaquina1(estudianteID);
                break;
            case 1:
                edificio.usarMaquina2(estudianteID);
                break;
            case 2:
                edificio.bano(estudianteID);
                break;
        }
        edificio.aula(estudianteID, numAula, true);
        try{
            sleep(30 * 1000);
        } catch(InterruptedException e){}
        edificio.aula(estudianteID, numAula, false);
    }
}
