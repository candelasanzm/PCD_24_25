package Teoria.Presentacion6.Ejercicio1;

public class CalcularPrimos implements Runnable {
    private final int inicio;
    private final int fin;

    public CalcularPrimos(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    private boolean esPrimo(int numero){
        if (numero < 2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        for (int i = inicio; i <= fin; i++) {
            if (esPrimo(i)){
                System.out.println("Primo " + i);
            }
        }
    }
}
