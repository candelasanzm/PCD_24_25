package Teoria.ExamenesAnteriores.Examen2.Examen202223.Ejercicio3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;

public class Examen {
    private CyclicBarrier cyclicBarrier;
    private CountDownLatch entregaPrimeraParte;
    private CountDownLatch entregaSegundaParte;
    private Exchanger<int[]> intercambioRespuestas;

    public Examen() {
        this.cyclicBarrier = new CyclicBarrier(41);
        this.entregaPrimeraParte = new CountDownLatch(40);
        this.entregaSegundaParte = new CountDownLatch(40);
        this.intercambioRespuestas = new Exchanger<>();
    }

    public void esperarInicio(){
        try {
            cyclicBarrier.await();
        } catch (Exception e) {}
    }

    public void realizarExamen() throws InterruptedException {
        System.out.println("Comienza la primera parte del examen");
        Thread.sleep(10000);
        System.out.println("Fin de la primera parte, hay un descanso de 5 segundos");
        Thread.sleep(5000);
        System.out.println("Empieza la segunda parte del examen");
        Thread.sleep(20000);
        System.out.println("Examen finalizado. Todos los estudiantes han entregado el examen");
    }

    public void entregarExamen(int[] respuestas) throws InterruptedException {
        intercambioRespuestas.exchange(respuestas);
        entregaPrimeraParte.countDown();
        entregaSegundaParte.countDown();
    }
}
