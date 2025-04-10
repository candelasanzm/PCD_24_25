package Laboratorio.Sesion6.Ejercicio3;

import java.util.concurrent.Callable;

public class CalculadorPrimos implements Callable<Long> {
    private final int inicio;
    private final int fin;

    public CalculadorPrimos(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    private Boolean esPrimo (int num){
        if (num < 2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Long call(){
        long suma = 0;
        for (int i = inicio; i <= fin; i++) {
            if (esPrimo(i)) {
                suma += i;
            }
        }
        return suma;
    }
}
