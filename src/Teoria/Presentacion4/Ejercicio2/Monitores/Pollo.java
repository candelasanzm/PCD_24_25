package Teoria.Presentacion4.Ejercicio2.Monitores;

public class Pollo extends Thread{
    private int id;
    private Corral corral;

    public Pollo(int id, Corral corral) {
        this.id = id;
        this.corral = corral;
    }

    public void run() {
        try {
            while (true) {
                corral.pasear(id, true);
                Thread.sleep((int) (Math.random() * 5000) + 5000); // (max - min + 1) + min
                corral.pasear(id, false);
                int accion = (int) (Math.random() * 4) + 1;
                switch (accion) {
                    case 1:
                        corral.comer(id, true);
                        Thread.sleep((int) (Math.random() * 5000) + 2000);
                        corral.comer(id, false);
                    case 2:
                        corral.pasear(id, true);
                        Thread.sleep((int) (Math.random() * 5000) + 5000);
                        corral.pasear(id, false);
                    case 3:
                        corral.beber(id, true);
                        Thread.sleep((int) (Math.random() * 3000) + 1000);
                        corral.beber(id, false);
                    case 4:
                        corral.dormir(id, true);
                        Thread.sleep((int) (Math.random() * 5000) + 15000);
                        corral.dormir(id, false);
                }
            }
        } catch (Exception e) {}
    }
}
