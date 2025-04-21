package Teoria.ExamenesAnteriores.Examen2.Examen201617.Ejercicio1.OtraForma;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Museo {
    private ArrayList<Visitantes> entradaEste = new ArrayList();
    private ArrayList<Visitantes> entradaOeste = new ArrayList();
    private ArrayList<Visitantes> dentroMuseo = new ArrayList();

    private int capacidadDisponible = 20;
    private int alternancia = 0; // indico si la última persona ha entrado por el este (0) u oeste(1)

    private Lock cerrojo = new ReentrantLock();
    private Condition este = cerrojo.newCondition();
    private Condition oeste = cerrojo.newCondition();

    public void entrar_museo_este(Visitantes visitante) {
        cerrojo.lock();
        try {
            entradaEste.add(visitante);
            while(dentroMuseo.size() >= capacidadDisponible) {
                este.await();
            }

            entradaEste.remove(visitante);
            dentroMuseo.add(visitante);
            System.out.println("Visitante " + visitante.getIdVisitante() + " entra por la entrada este. Hay " + dentroMuseo.size() + " personas dentro. Colas " + entradaEste.size() + "; " + entradaOeste.size());
        } catch (InterruptedException e){}
        finally {
            cerrojo.unlock();
        }
    }

    public void entrar_museo_oeste(Visitantes visitante) {
        cerrojo.lock();
        try {
            entradaOeste.add(visitante);
            while(dentroMuseo.size() >= capacidadDisponible) {
                oeste.await();
            }

            entradaOeste.remove(visitante);
            dentroMuseo.add(visitante);
            System.out.println("Visitante " + visitante.getIdVisitante() + " entra por la entrada oeste. Hay " + dentroMuseo.size() + " personas dentro. Colas " + entradaOeste.size());
        } catch (InterruptedException e){}
        finally {
            cerrojo.unlock();
        }
    }

    public void salir_museo(Visitantes visitante) {
        cerrojo.lock();
        try {
            dentroMuseo.remove(visitante);
            System.out.println("Visitante " + visitante.getIdVisitante() + " sale. Hay " + dentroMuseo.size() + " personas dentro. Colas " + entradaEste.size() + "; " + entradaOeste.size());
            if (entradaEste.size() > 0 && entradaOeste.size() > 0) {
                if (alternancia == 0) {
                    oeste.signal();
                    alternancia = 1;
                } else {
                    este.signal();
                    alternancia = 0;
                }
            } else {
                if (entradaEste.size() > 0) {
                    este.signal();
                } else {
                    oeste.signal();
                }
            }
        } finally {
            cerrojo.unlock();
        }
    }
}
