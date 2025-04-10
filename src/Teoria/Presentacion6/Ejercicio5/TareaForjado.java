package Teoria.Presentacion6.Ejercicio5;

public class TareaForjado implements Runnable {
    private final int idViga;

    public TareaForjado(int idViga) {
        this.idViga = idViga;
    }

    @Override
    public void run() {
        try{
            System.out.println("Iniciando el forjado de la viga " + idViga);
            Thread.sleep(12000);
            System.out.println("Viga " + idViga + " completada");
        } catch (InterruptedException e) {
            System.out.println("Error en el forjado de la viga " + idViga);
            Thread.currentThread().interrupt();
        }
    }
}
