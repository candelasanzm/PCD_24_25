package Teoria.ExamenesAnteriores.Examen1.PECT1_22_23Bis;

public class Personas extends Thread{
    private int personaID;
    private int barraID;
    private int edad;
    Discoteca discoteca;

    public Personas(int personaID, Discoteca discoteca) {
        this.personaID = personaID;
        this.barraID = 1 + (int) (Math.random() * 2);
        this.edad = 16 + (int) (Math.random() * 14);
        this.discoteca = discoteca;
    }

    private void esperar(int segundos){
        try{
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void run(){
        // Las personas se registran
        discoteca.acceso(personaID, edad, true);

        // Acudiran a las barras
        discoteca.barra(barraID, personaID);

        // Baile durante un tiempo
        int tiempoBaile = 20 + (int) (Math.random() * 11);
        esperar(tiempoBaile);

        // Seleccion aleatoria entre ir a la barra o al baño
        int eleccion = (int) (Math.random() * 2);
        switch (eleccion){
            case 0:
                discoteca.barra(barraID, personaID);
            case 1:
                discoteca.servicio(personaID);
        }

        // Volver a la pista de baile
        esperar(30);

        // Salir de la discoteca
        discoteca.acceso(personaID, edad, false);
    }
}
