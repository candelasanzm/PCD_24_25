package Teoria.Presentacion4.Ejercicio2.Monitores;

public class Corral {
    private int comedero = 4;
    private int bebedero = 8;
    private int camas = 10;

    public Corral(){}

    public void pasear(int id, boolean entra){
        if (entra){
            System.out.println("Pollo " + id + " pasea");
        } else {
            System.out.println("Pollo " + id + " termina su paseo");
        }
    }

    public synchronized void comer(int id, boolean entra) throws InterruptedException {
        if (entra){
            while (comedero == 0){
                wait();
            }
            comedero--;
            System.out.println("Pollo " + id + " come");
        } else {
            comedero ++;
            System.out.println("Pollo " + id + " termina de comer");
            notifyAll();
        }
    }

    public synchronized void beber (int id, boolean entra) throws InterruptedException {
        if (entra){
            while (bebedero == 0){
                wait();
            }
            bebedero--;
            System.out.println("Pollo " + id + " bebe");
        } else {
            bebedero ++;
            System.out.println("Pollo " + id + " termina de beber");
            notifyAll();
        }
    }

    public synchronized void dormir (int id, boolean entra) throws InterruptedException {
        if (entra){
            while (camas == 0){
                wait();
            }
            camas --;
            System.out.println("Pollo " + id + " duerme");
        } else {
            camas ++;
            System.out.println("Pollo " + id + " se despierta");
            notifyAll();
        }
    }
}
