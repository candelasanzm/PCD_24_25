package Teoria.ExamenesAnteriores.Examen2.Examen201516.Ejercicio2;

public class TareaEmpaquetado implements Runnable {
    private String tipo;

    public TareaEmpaquetado(String tipo) {
        this.tipo = tipo;
    }

    public void run() {
        System.out.println("Tarea de empaquetado de tipo " + tipo + " iniciada");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException al empaquetar las prendas " + e.toString());
        }
        System.out.println("Tarea de empaquetado de tipo " + tipo + " finalizada");
    }
}
