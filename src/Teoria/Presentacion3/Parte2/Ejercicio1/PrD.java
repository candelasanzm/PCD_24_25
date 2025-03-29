package Teoria.Presentacion3.Parte2.Ejercicio1;

public class PrD extends Thread {
    Sistema sis;

    public PrD(Sistema sis) {
        this.sis = sis;
    }

    public void run(){
        try{
            while(true){
                sis.media();
                sleep (3000 + (int) (Math.random() * 1000));
            }
        } catch (Exception e){}
    }
}
