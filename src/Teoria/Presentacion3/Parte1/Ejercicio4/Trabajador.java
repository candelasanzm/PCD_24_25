package Teoria.Presentacion3.Parte1.Ejercicio4;

public class Trabajador extends Thread {
    private Edificio edificio;
    private int trabajadorID;

    public Trabajador(int trabajadorID, Edificio edificio) {
        this.trabajadorID = trabajadorID;
        this.edificio = edificio;
    }

    public void run(){
        //Inicio jornada laboral
        edificio.ficharEntrada(trabajadorID);

        //Preparar cafe
        edificio.prepararCafe();

        //Acudir a su mesa de trabajo
        edificio.trabajar(trabajadorID);

        //Segundo cafe para ID par
        if (trabajadorID % 2 == 0){
            edificio.prepararCafe();
        }

        //Volver a trabajar
        edificio.trabajar(trabajadorID);

        //Fichar salida
        edificio.ficharSalida(trabajadorID);
    }
}
