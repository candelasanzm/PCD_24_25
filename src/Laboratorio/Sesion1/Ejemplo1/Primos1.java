package Laboratorio.Sesion1.Ejemplo1;

public class Primos1 {
    private int x,y,n=0;

    public Primos1(int x, int y){
        this.x=x;
        this.y=y;
    }

    private boolean esPrimo(int n){
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

    public void calcular(){
        for (int i=x; i<=y; i++) {
            if(esPrimo(i)) {
                n++;
            }
        }
    }

    public int cuantos(){
        return n;
    }
}
