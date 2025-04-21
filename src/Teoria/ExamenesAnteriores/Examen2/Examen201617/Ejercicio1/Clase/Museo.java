package Teoria.ExamenesAnteriores.Examen2.Examen201617.Ejercicio1.Clase;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Museo {
    private ArrayList<Visitantes> visitantesDentro = new ArrayList();
    private Lock entradaCerrojo = new ReentrantLock();
    private Condition entrar = entradaCerrojo.newCondition();

    public Museo() {}

    public void entrar_museo_este(Visitantes visitante, int idVisitante){
        entradaCerrojo.lock();
        try {
            while (visitantesDentro.size() >= 20){
                entrar.await();
            }
            visitantesDentro.add(visitante);
            System.out.println("Visitante " + idVisitante + " ha entrado al museo por la entrada este");
        } catch (InterruptedException e){}
        finally {
            entradaCerrojo.unlock();
        }
    }

    public void entrar_museo_oeste(Visitantes visitante, int idVisitante){
        entradaCerrojo.lock();
        try {
            while (visitantesDentro.size() >= 20){
                entrar.await();
            }
            visitantesDentro.add(visitante);
            System.out.println("Visitante " + idVisitante + " ha entrado al museo por la entrada oeste");
        } catch (InterruptedException e){}
        finally {
            entradaCerrojo.unlock();
        }
    }

    public void salir_museo(Visitantes visitante, int idVisitante){
        entradaCerrojo.lock();
        try {
            entrar.signalAll();
            visitantesDentro.remove(visitante);
            System.out.println("Visitante " + idVisitante + " ha salido del museo");
        } catch (Exception e){}
        finally {
            entradaCerrojo.unlock();
        }
    }
}
