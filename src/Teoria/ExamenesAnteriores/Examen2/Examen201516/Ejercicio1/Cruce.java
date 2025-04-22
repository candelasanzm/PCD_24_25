package Teoria.ExamenesAnteriores.Examen2.Examen201516.Ejercicio1;

public class Cruce {
    private boolean semaforoOesteVerde;
    private boolean cocheEnCruce;

    public Cruce(){
        semaforoOesteVerde = true;
        cocheEnCruce = false;
    }

    public synchronized void esperarSemaforo(boolean vieneDelOeste) throws InterruptedException{
        while (vieneDelOeste != semaforoOesteVerde || cocheEnCruce){
            wait();
        }
        cocheEnCruce = true;
    }

    public synchronized void salirCruce(){
        cocheEnCruce = false;
        notifyAll();
    }

    public synchronized void cambiarSemaforo(){
        semaforoOesteVerde = !semaforoOesteVerde;
        notifyAll();
    }
}
