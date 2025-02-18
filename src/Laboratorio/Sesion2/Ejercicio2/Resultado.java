package Laboratorio.Sesion2.Ejercicio2;
import java.math.BigInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resultado {

    private BigInteger suma = new BigInteger("0");

    Lock cerrojo = new ReentrantLock();

    public BigInteger getSuma() {
        return suma;
    }

    public void sumar(int n) {
        cerrojo.lock();
        BigInteger bn = new BigInteger(String.valueOf(n));
        suma=suma.add(bn);
        cerrojo.unlock();
        //System.out.println("sumar " + String.valueOf(n) +" = "+ suma.toString());
    }
}