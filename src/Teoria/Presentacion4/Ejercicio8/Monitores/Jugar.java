package Teoria.Presentacion4.Ejercicio8.Monitores;

public class Jugar {
    private int ninios = 0;
    private boolean esperarCompanero = false;

    public Jugar(){}

    public synchronized void montar(int id){
        try{
            while (ninios == 2){
                wait();
            }
            ninios ++;
            System.out.println("Niño " + id + " se monta en el columpio. Niños en el columpio: " + ninios);

            while (ninios < 1){
                System.out.println("Niño " + id + " espera a otro niño");
                wait();
            }

            System.out.println("Niño " + id + " juega en el columpio con otro niño");
        } catch (Exception e){}
    }

    public synchronized void bajar(int id){
        System.out.println("Niño " + id + " se baja del columpio");
        ninios--;
        notifyAll();
    }
}
