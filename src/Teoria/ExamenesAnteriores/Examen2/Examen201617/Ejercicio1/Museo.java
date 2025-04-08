package Teoria.ExamenesAnteriores.Examen2.Examen201617.Ejercicio1;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Museo {
    private Lock cerrojo = new ReentrantLock();
    private Condition condition = cerrojo.newCondition();
    private ArrayList<Visitantes> visitantesDentro = new ArrayList();

    public void entrar_museo_este(Visitantes visitante){
        cerrojo.lock();
        try{
            while(visitantesDentro.size() >= 20){
               condition.await();
            }
            visitantesDentro.add(visitante);
        } catch (Exception e){}
        finally {
            cerrojo.unlock();
        }
    }

    public void entrar_museo_oeste(Visitantes visitante){
        cerrojo.lock();
        try{
            while(visitantesDentro.size() >= 20){
                condition.await();
            }
            visitantesDentro.add(visitante);
        } catch (Exception e){}
        finally {
            cerrojo.unlock();
        }
    }

    public void salir_museo(Visitantes visitante){
        try {
            cerrojo.lock();
            condition.signalAll();
            visitantesDentro.remove(visitante);
        } catch (Exception e){  }
        finally {
            cerrojo.unlock();
        }
    }
}
