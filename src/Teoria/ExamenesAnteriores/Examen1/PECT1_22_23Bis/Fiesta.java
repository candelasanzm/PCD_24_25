package Teoria.ExamenesAnteriores.Examen1.PECT1_22_23Bis;

public class Fiesta {
    public static void main(String[] args) {
        Discoteca discoteca = new Discoteca();

        for (int i = 0; i < 100; i++) {
            Personas personas = new Personas(i, discoteca);
            personas.start();
            try{
                Thread.sleep(500);
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
