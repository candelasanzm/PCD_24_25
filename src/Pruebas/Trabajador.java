package Pruebas;

public class Trabajador extends Thread {
    private int trabajadorID;
    Edificio edificio;

    public Trabajador(int trabajadorID, Edificio edificio) {
        this.trabajadorID = trabajadorID;
        this.edificio = edificio;
    }

    public void run() {
        edificio.fichar(trabajadorID, true);
        edificio.prepararCafe(trabajadorID);
        edificio.trabajar(trabajadorID);
        if (trabajadorID % 2 == 0){
            edificio.prepararCafe(trabajadorID);
            edificio.trabajar(trabajadorID);
        }
        edificio.fichar(trabajadorID, false);
    }
}
