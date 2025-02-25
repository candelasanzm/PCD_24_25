package Teoria.ExamenesAnteriores.Examen1.PECT1_22_23;

public class Estudiantes extends Thread{
    private int estudianteID;
    private int numeroIdioma;
    private Escuela escuela;

    public Estudiantes(int estudianteID, int numeroIdioma, Escuela escuela) {
        this.estudianteID = estudianteID;
        this.numeroIdioma = numeroIdioma;
        this.escuela = escuela;
    }

    private void esperar(int segundos){
        try{
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void run() {
        if (numeroIdioma == 1) {
            escuela.aula1.userElemento(estudianteID, 1, true);
            esperar(30);
            escuela.aula1.userElemento(estudianteID, 1, false);
        } else {
            escuela.aula1.userElemento(estudianteID, 1, true);
            esperar(30);
            escuela.aula1.userElemento(estudianteID, 1, false);
        }

        int eleccion = (int) (Math.random() * 3);
        switch (eleccion) {
            case 1:
                escuela.baño.userElemento(estudianteID, 3, true);
            case 2:
                escuela.maquina1.userElemento(estudianteID, 5, true);
            case 3:
                escuela.maquina2.userElemento(estudianteID, 5, true);
        }
    }
}
