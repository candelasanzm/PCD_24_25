package Teoria.Presentacion4.Ejercicio2.Monitores;

public class Corral {
    private int comedero = 4;
    private int bebedero = 8;
    private int camas = 10;

    public Corral(){}

    public void pasear(int id, boolean pasea){
        if (pasea){
            System.out.println("Pollo " + id + " pasea");
        } else {
            System.out.println("Pollo " + id + " termina de pasear");
        }
    }

    public synchronized void comer(int id, boolean come) throws InterruptedException{
        if (come){
            while(comedero == 0){
                System.out.println("Pollo " + id + " está esperando para comer");
                wait();
            }

            comedero--;
            System.out.println("Pollo " + id + " está comiendo");
        } else {
            comedero++;
            System.out.println("Pollo " + id + " ha terminado de comer");
            notifyAll();
        }
    }

    public synchronized void beber(int id, boolean bebe) throws InterruptedException{
        if (bebe){
            while(bebedero == 0){
                System.out.println("Pollo " + id + " está esperando para beber");
                wait();
            }

            bebedero--;
            System.out.println("Pollo " + id + " está bebiendo");
        } else {
            bebedero++;
            System.out.println("Pollo " + id + " ha terminado de beber");
            notifyAll();
        }
    }

    public synchronized void dormir (int id, boolean duerme) throws InterruptedException{
        if (duerme){
            while(camas == 0){
                System.out.println("Pollo " + id + " está esperando a que haya una cama libre");
                wait();
            }

            camas--;
            System.out.println("Pollo " + id + " está durmiendo");
        } else {
            camas++;
            System.out.println("Pollo " + id + " se ha despertado");
            notifyAll();
        }
    }
}
