package Teoria.Presentacion3.Parte2.Ejercicio6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Sistema {
    private ReadWriteLock cerrojo = new ReentrantReadWriteLock();
    private Lock read = cerrojo.readLock();
    private Lock write = cerrojo.writeLock();
    private int[] valores = new int[10];

    public Sistema(){}

    public void escribir(){
        write.lock();
        try {
            for (int i = 0; i < valores.length; i++){
                valores[i] = (int)(Math.random() * 100);
            }
            System.out.println("Generador ha actualizado los datos");
        } catch (Exception e){
        } finally {
            write.unlock();
        }
    }

    public int[] leer(){
        read.lock();
        try{
            int[] muestra = new int[4];
            for (int i = 0; i < 4; i++){
                muestra[i] = valores[(int)(Math.random() * (valores.length))];
            }
            return muestra;
        } catch (Exception e){
            return null;
        }
        finally {
            read.unlock();
        }
    }
}
