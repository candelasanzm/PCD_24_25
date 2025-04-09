package Teoria.Presentacion4.Ejercicio7.Semaforos;

public class Trabajador extends Thread {
    private Empresa empresa;
    private int trabajadorID;

    public Trabajador(int trabajadorID, Empresa empresa) {
        this.trabajadorID = trabajadorID;
        this.empresa = empresa;
    }

    public void run(){
        //Inicio jornada laboral
        empresa.fichar(trabajadorID, true);

        //Preparar cafe
        empresa.prepararCafe();

        //Acudir a su mesa de trabajo
        empresa.trabajar(trabajadorID);

        //Segundo cafe para ID par
        if (trabajadorID % 2 == 0){
            empresa.prepararCafe();

            //Volver a trabajar
            empresa.trabajar(trabajadorID);
        }

        //Fichar salida
        empresa.fichar(trabajadorID, false);
    }
}
