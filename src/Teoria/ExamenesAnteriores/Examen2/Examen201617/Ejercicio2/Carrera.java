package Teoria.ExamenesAnteriores.Examen2.Examen201617.Ejercicio2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Carrera {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(22); // 22 porque se cuentan también los de seguridad
    CountDownLatch countDownLatch = new CountDownLatch(2);
    CountDownLatch countDownLatch2 = new CountDownLatch(20);

    public void esperar(){
        try {
            cyclicBarrier.await();
        } catch (Exception e){}
    }

    public void arrancaCarrera(){
        try {
            countDownLatch.await();
        } catch (Exception e){}
    }

    public void reconocimiento(){
        try {
            countDownLatch.countDown();
        } catch (Exception e){}
    }

    public void finalizarCarrera(){
        try {
            countDownLatch2.await();
        } catch (Exception e){}
    }

    public void vueltaFinal(){
        try {
            countDownLatch2.countDown();
        } catch (Exception e){}
    }
}