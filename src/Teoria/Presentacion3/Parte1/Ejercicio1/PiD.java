package Teoria.Presentacion3.Parte1.Ejercicio1;

public class PiD extends Thread {
    int id;
    Sistema sis;

    public PiD(int id, Sistema sis) {
        this.id = id;
        this.sis = sis;
    }

    public void run(){
        try{
            while(true){
                sis.media();
                sleep(3000 + (int) Math.random() * 1000);
            }
        } catch (InterruptedException e) {}
    }
}
