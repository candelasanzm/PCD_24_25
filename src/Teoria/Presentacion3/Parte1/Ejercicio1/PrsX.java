package Teoria.Presentacion3.Parte1.Ejercicio1;

public class PrsX extends Thread{
    int id;
    Sistema sis = new Sistema();

    public PrsX(int id, Sistema sis) {
        this.id = id;
        this.sis = sis;
    }

    public void run(){
        while(true){
            int temp = 5; // habria que poner leerValor() que seria una funcion que nos tendrian que dar pero pongo 5 para que no de error
            try {
                sis.escribir(temp, id);
                sleep(1000 + (int) (Math.random() * 1000));
            } catch (InterruptedException e) {}
        }
    }
}
