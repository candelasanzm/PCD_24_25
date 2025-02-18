package Laboratorio.Sesion1.Ejemplo1;

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
        p2.calcular();
        p3.calcular();
        p4.calcular();
        p5.calcular();

        int n = p1.cuantos() + p2.cuantos() + p3.cuantos() + p4.cuantos() + p5.cuantos();
        long t1 = (new Date()).getTime(); //t1=instante de final de los cálculos

        System.out.println("Número de primos menores que 10.000.000: "+ n +" calculado en "+ (t1-t0) +" miliseg.");
    }
}
