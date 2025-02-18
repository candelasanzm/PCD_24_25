package Laboratorio.Sesion1.Ejercicio1;

import Laboratorio.Sesion1.Ejemplo1.Primos1;

import java.util.Date;

public class CuantosPrimos1 {
    public static void main(String[] x){

        long t0 = (new Date()).getTime(); //t0=instante de inicio de los cálculos

        Primos1 p1 = new Primos1(1,2000000);
        Primos1 p2 = new Primos1(2000001,4000000);
        Primos1 p3 = new Primos1(4000001,6000000);
        Primos1 p4 = new Primos1(6000001,8000000);
        Primos1 p5 = new Primos1(8000001,10000000);

        p1.calcular();
        long t2 = (new Date()).getTime();
        p2.calcular();
        long t3 = (new Date()).getTime();
        p3.calcular();
        long t4 = (new Date()).getTime();
        p4.calcular();
        long t5 = (new Date()).getTime();
        p5.calcular();

        int n = p1.cuantos() + p2.cuantos() + p3.cuantos() + p4.cuantos() + p5.cuantos();
        long t1 = (new Date()).getTime(); //t1=instante de final de los cálculos

        long tiempo = (t2 - t0) + (t3 - t2) + (t4 - t3) + (t5 - t4) + (t1 - t5);

        System.out.println("Número de primos menores que 10.000.000: " + n + " calculado en "+ (t1-t0) +" miliseg.");
        System.out.println("Número de primos menores que 2.000.000: " + p1.cuantos() + " calculado en "+ (t2-t0) +" miliseg.");
        System.out.println("Número de primos menores que 4.000.000 y mayores que 2.000.000: " + p2.cuantos() + " calculado en "+ (t3-t2) +" miliseg.");
        System.out.println("Número de primos menores que 6.000.000 y mayores que 4.000.000: " + p3.cuantos() + " calculado en "+ (t4-t3) +" miliseg.");
        System.out.println("Número de primos menores que 8.000.000 y mayores que 6.000.000: " + p4.cuantos() + " calculado en "+ (t5-t4) +" miliseg.");
        System.out.println("Número de primos menores que 10.000.000 y mayores que 8.000.000: " + p5.cuantos() + " calculado en "+ (t1-t5) +" miliseg.");
        System.out.println("Número total de miliseg: " + tiempo);
    }
}
