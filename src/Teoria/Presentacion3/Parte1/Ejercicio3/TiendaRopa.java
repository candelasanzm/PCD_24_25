package Teoria.Presentacion3.Parte1.Ejercicio3;

public class TiendaRopa {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new ProgramaTienda(i).start();
            try{
                Thread.sleep((int) (Math.random() * 1500));
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
