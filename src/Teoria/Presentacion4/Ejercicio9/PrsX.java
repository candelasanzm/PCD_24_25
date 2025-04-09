package Teoria.Presentacion4.Ejercicio9;

public class PrsX extends Thread{
    int id;
    Sistema sis;

    public PrsX(int id, Sistema sis) {
        this.id = id;
        this.sis = sis;
    }

    public void run(){
        try {
            while(true){
                int temp = 10 + (int)(Math.random() * 15);
                sis.escribir(temp, id);
                sleep(1000 + (int) (Math.random() * 1000));
            }
        } catch (Exception e) {}
    }
}
