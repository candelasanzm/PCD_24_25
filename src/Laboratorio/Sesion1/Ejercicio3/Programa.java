package Laboratorio.Sesion1.Ejercicio3;

public class Programa extends Thread {
    private int x, y, n = 0, m = 0, t = 0;

    public Programa(int x, int y){
        this.x = x;
        this.y = y;
    }

    private boolean multiplo7(int n){
        return n % 7 == 0;
    }

    private boolean acaba3o5(int n){
        return n % 10 == 5 || n % 10 == 3;
    }

    private boolean primo(int n){
        int raiz = (int) Math.sqrt((double) n);
        boolean primo = true;
        int i=2;
        while(primo && i<=raiz) {
            if (n % i == 0)
                primo=false;
            i++;
        }
        return primo;
    }

    public void run(){
        for (int i = x; i <= y; i++) {
            if(multiplo7(i)) {
                n += i;
            }
            if (acaba3o5(i)) {
                m += i;
            }
            if (primo(i)) {
                t += i;
            }
        }
    }

    public int suma7(){
        return n;
    }

    public int suma3o5(){
        return m;
    }

    public int sumaPrimo(){
        return t;
    }
}
