package Teoria.ExamenesAnteriores.Examen2.Examen202223.Ejercicio2;

public class Persona extends Thread {
    private int id;
    private Cafeteria cafeteria;

    public Persona(int id, Cafeteria cafeteria) {
        this.id = id;
        this.cafeteria = cafeteria;
    }

    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 3000) + 2000);
            cafeteria.entrar(id);
            cafeteria.elegirSitio(id);
            cafeteria.pagar(id);
            cafeteria.salir(id);
        } catch (InterruptedException e){}
    }
}
