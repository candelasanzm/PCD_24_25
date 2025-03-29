package Teoria.Presentacion3.Parte2.Ejercicio1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sistema {
    Lock cerrojo = new ReentrantLock();
    private Condition nuevaTemp = cerrojo.newCondition();
    private int temp1, temp2, temp3 = 0;
    private String display = "";

    public Sistema(){}

    public void escribir(int valor, int id){
        cerrojo.lock();
        try{
            switch(id){
                case 1:
                    temp1 = valor;
                    break;
                case 2:
                    temp2 = valor;
                    break;
                case 3:
                    temp3 = valor;
                    break;
            }
            nuevaTemp.signal(); // se han escrito nuevos datos
        } finally {
            cerrojo.unlock();
        }
    }

    public void media(){
        cerrojo.lock();
        try {
            while (temp1 == 0 || temp2 == 0 || temp3 == 0){
                nuevaTemp.await(); // Espera a que haya datos
            }
            int media = (temp1 + temp2 + temp3) / 3;
            display = "Temperatura = " + media;
            System.out.println(display);
        } catch (Exception e) {}
        finally {
            cerrojo.unlock();
        }
    }
}
