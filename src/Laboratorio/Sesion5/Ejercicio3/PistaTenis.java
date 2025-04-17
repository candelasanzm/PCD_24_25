package Laboratorio.Sesion5.Ejercicio3;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class PistaTenis {
    private ArrayList<Integer> esperando = new ArrayList<>();
    private ArrayList<Integer> enPista = new ArrayList<>();
    private Semaphore mutex = new Semaphore(1); // exclusión mutua
    private Semaphore pista = new Semaphore(2, true); // permite máximo dos jugadores en pista

    public void entrarPista (int id) throws InterruptedException {
        mutex.acquire();
        esperando.add(id);
        System.out.println("Esperando para entrar " + esperando);
        mutex.release();

        while (true) {
            pista.acquire();
            mutex.acquire();

            // Verificar si puede entrar (mismo sexo o pista vacía)
            if (enPista.isEmpty() || (id % 2 == enPista.get(0) % 2)) {
                esperando.remove((Integer) id); // Quitar de la lista de espera
                enPista.add(id); // Añadir a la pista
                System.out.println("En pista: " + enPista);
                mutex.release();
                break; // Salir del bucle, ya ha entrado
            } else {
                // No puede entrar, liberar espacio y continuar esperando
                mutex.release();
                pista.release();
                Thread.sleep(100); // Esperar un momento antes de intentar nuevamente
            }
        }

        if (enPista.size() == 2){
            jugarPartido();
        }

        mutex.acquire();
        enPista.remove((Integer) id);
        System.out.println("En pista " + enPista);
        mutex.release();

        pista.release();
    }

    private void jugarPartido(){
        try {
            System.out.println("Tenistas en pista " + enPista + " están jugando");
            Thread.sleep(500 + (int)(Math.random() * 500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
