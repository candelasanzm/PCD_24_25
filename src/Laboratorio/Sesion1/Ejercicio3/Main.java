package Laboratorio.Sesion1.Ejercicio3;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        long t1 = 0, t2 = 0, t3 = 0, t4 = 0;

        Programa p1 = new Programa(1, 2000);
        Programa p2 = new Programa(2001, 4000);
        Programa p3 = new Programa(4001, 6000);
        Programa p4 = new Programa(6001, 8000);
        Programa p5 = new Programa(8001, 10000);

        long t0 = (new Date()).getTime();

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

        try{
            p1.join();
            t1 = (new Date()).getTime();
            System.out.println("Tiempo hilo 1: " + (t1 - t0));
            p2.join();
            t2 = (new Date()).getTime();
            System.out.println("Tiempo hilo 2: " + (t2 - t0));
            p3.join();
            t3 = (new Date()).getTime();
            System.out.println("Tiempo hilo 3: " + (t3 - t0));
            p4.join();
            t4 = (new Date()).getTime();
            System.out.println("Tiempo hilo 4: " + (t4 - t0));
            p5.join();
        } catch (InterruptedException e){}

        long t5 = (new Date()).getTime();
        System.out.println("Tiempo hilo 5: " + (t5 - t0));

        int sum1 = p1.suma7() + p2.suma7() + p3.suma7() + p4.suma7() + p5.suma7();
        int sum2 = p1.suma3o5() + p2.suma3o5() + p3.suma3o5() + p4.suma3o5() + p5.suma3o5();
        int sum3 = p1.sumaPrimo() + p2.sumaPrimo() + p3.sumaPrimo() + p4.sumaPrimo() + p5.sumaPrimo();
        long tiempo = ((t1 - t0) + (t2 - t0) + (t3 - t0) + (t4 - t0) + (t5 - t0));

        System.out.println("Suma de los múltiplos de 7 entre 1 y 100000: " + sum1);
        System.out.println("Suma de los números acabados en 3 o 5 de 7 entre 1 y 100000: " + sum2);
        System.out.println("Suma de los números primos de 7 entre 1 y 100000: " + sum3);
        System.out.println("Tiempo total que tarda el programa: " + tiempo);
    }
}
