package Teoria.Presentacion4.Ejercicio6.Monitores;

public class Tienda {
    private boolean[] probadores = new boolean[4];
    private boolean caja = true;

    public Tienda() {}

    public synchronized int entrarProbador(int id, int numPrendas) throws InterruptedException {
        while (true){
            for (int i = 0; i < probadores.length; i++) {
                if (!probadores[i]) {
                    probadores[i] = true;
                    System.out.println("Cliente " + id + " entra al probador " + (i + 1));
                    return i;
                }
            }
            wait();
        }
    }

    public synchronized void salirProbador(int id, int probador) {
        probadores[probador] = false;
        System.out.println("Cliente " + id + " sale del probador " + (probador + 1));
        notify();
    }

    public synchronized void pagar(int id, int numPrendas) throws InterruptedException {
        while (!caja){
            wait();
        }
        caja = false;
        System.out.println("Cliente " + id + " está pagando " + numPrendas + " prendas");
    }

    public synchronized void terminarPago(int id){
        caja = true;
        System.out.println("Cliente " + id + " ha terminado de pagar");
        notify();
    }
}
