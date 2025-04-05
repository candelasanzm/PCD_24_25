package Teoria.Presentacion4.Ejercicio2.Semaforos;

public class Pollo extends Thread{
    private int id;
    private Corral corral;

    public Pollo(int id, Corral corral){
        this.id = id;
        this.corral = corral;
    }

    public void run(){
        try{
            while(true){
                corral.pasear(id,true);
                Thread.sleep((int)(Math.random() * 5000) + 5000);
                corral.pasear(id,false);
                int accion = (int)(Math.random() * 4) + 1;
                switch (accion){
                    case(1):
                        corral.comer(id);
                    case(2):
                        corral.pasear(id,true);
                        Thread.sleep((int)(Math.random() * 5000) + 5000);
                        corral.pasear(id,false);
                    case(3):
                        corral.beber(id);
                    case(4):
                        corral.dormir(id);
                }
            }
        } catch(Exception e){}
    }
}