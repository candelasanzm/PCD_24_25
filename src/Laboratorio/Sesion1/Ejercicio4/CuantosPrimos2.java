package Laboratorio.Sesion1.Ejercicio4;

import java.util.Date;

public class CuantosPrimos2 {
    public static void main(String[] x){

        long t0 = (new Date()).getTime(); //t0=instante de inicio de los cálculos

        PrimosThread pt1 = new PrimosThread(1,2000000);
        PrimosThread pt2 = new PrimosThread(2000001,4000000);
        PrimosThread pt3 = new PrimosThread(4000001,6000000);
        PrimosThread pt4 = new PrimosThread(6000001,8000000);
        PrimosThread pt5 = new PrimosThread(8000001,10000000);

        Thread p1 = new Thread(pt1);
        Thread p2 = new Thread(pt2);
        Thread p3 = new Thread(pt3);
        Thread p4 = new Thread(pt4);
        Thread p5 = new Thread(pt5);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

        try{
            p1.join(); p2.join(); p3.join(); p4.join(); p5.join(); //esperamos a que terminen todos
        } catch (InterruptedException e){}

        int n = pt1.cuantos() + pt2.cuantos() + pt3.cuantos() + pt4.cuantos() + pt5.cuantos();
        long t1 = (new Date()).getTime(); //t1=instante de final de los cálculos

        System.out.println("Número de primos menores que 10.000.000: "+ n +" calculado en "+ (t1-t0) +" miliseg.");

    }
}
