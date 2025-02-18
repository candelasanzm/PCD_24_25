package Laboratorio.Sesion1.Ejercicio2;

import java.util.Date;

public class CuantosPrimos2 {
    public static void main(String[] x){

        long t2 = 0, t3 = 0, t4 = 0, t5 = 0;

        long t0 = (new Date()).getTime(); //t0=instante de inicio de los cálculos

        PrimosThread p1 = new PrimosThread(1,2000000);
        PrimosThread p2 = new PrimosThread(2000001,4000000);
        PrimosThread p3 = new PrimosThread(4000001,6000000);
        PrimosThread p4 = new PrimosThread(6000001,8000000);
        PrimosThread p5 = new PrimosThread(8000001,10000000);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

        try{
            p1.join();
            t2 = (new Date()).getTime();
            p2.join();
            t3 = (new Date()).getTime();
            p3.join();
            t4 = (new Date()).getTime();
            p4.join();
            t5 = (new Date()).getTime();
            p5.join(); //esperamos a que terminen todos
        } catch (InterruptedException e){}

        int n = p1.cuantos() + p2.cuantos() + p3.cuantos() + p4.cuantos() + p5.cuantos();
        long t1 = (new Date()).getTime(); //t1=instante de final de los cálculos

        long tiempo = (t2 - t0) + (t3 - t2) + (t4 - t3) + (t5 - t4) + (t1 - t5);

        System.out.println("Número de primos menores que 10.000.000: "+ n +" calculado en "+ (t1-t0) +" miliseg.");
        System.out.println("Número de primos menores que 2.000.000: " + p1.cuantos() + " calculado en "+ (t2-t0) +" miliseg.");
        System.out.println("Número de primos menores que 4.000.000 y mayores que 2.000.000: " + p2.cuantos() + " calculado en "+ (t3-t2) + " miliseg");
        System.out.println("Número de primos menores que 6.000.000 y mayores que 4.000.000: " + p3.cuantos() + " calculado en "+ (t4-t3) +" miliseg.");
        System.out.println("Número de primos menores que 8.000.000 y mayores que 6.000.000: " + p4.cuantos() + " calculado en "+ (t5-t4) +" miliseg.");
        System.out.println("Número de primos menores que 10.000.000 y mayores que 8.000.000: " + p5.cuantos() + " calculado en "+ (t1-t5) +" miliseg.");
        System.out.println("Número total de miliseg: " + tiempo);
    }
}
