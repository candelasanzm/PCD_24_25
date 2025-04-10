package Teoria.Presentacion6.Ejercicio2;

import java.util.concurrent.atomic.AtomicLong;

public class CalcularSuma implements Runnable {
    private final int inicio;
    private final int fin;
    private final AtomicLong suma;

    public CalcularSuma(int inicio, int fin, AtomicLong suma) {
        this.inicio = inicio;
        this.fin = fin;
        this.suma = suma;
    }

    private boolean esPrimo(int n) {
        if (n < 2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        long sumaPrimos = 0;
        for (int i = inicio; i <= fin; i++) {
            if (esPrimo(i)) {
                sumaPrimos += i;
            }
        }
        suma.addAndGet(sumaPrimos);
    }
}
