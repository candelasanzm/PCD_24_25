package Teoria.ExamenesAnteriores.Examen2.Examen202122;

public class Ave extends Thread {
    private int id;
    private String tipo;
    private Comedero comedero;

    public Ave(int id, String tipo, Comedero comedero) {
        this.id = id;
        this.tipo = tipo;
        this.comedero = comedero;
    }

    public void run() {
        try {
            boolean pudoComer = comedero.entrarComedero(tipo);

            if(pudoComer){
                System.out.println("Ave " + id + " de tipo " + tipo + " está comiendo");
                Thread.sleep((int)(Math.random() * 3000) + 3000);
                comedero.salirComedero();
            } else {
                System.out.println("Ave " + id + " de tipo " + tipo + " no pudo comer");
            }
        } catch (InterruptedException e){}
    }
}
