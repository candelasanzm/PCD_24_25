package Teoria.Presentacion6.Ejercicio5;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ejercicio5 {
    public static void main(String[] args) {
        ExecutorService exFundir = Executors.newFixedThreadPool(7);
        ExecutorService exForjar = Executors.newFixedThreadPool(5);

        ArrayList<Future<Boolean>> resultadosFundir = new ArrayList<>();

        for (int i = 0; i < 500; i++){
            TareaFundido fundido = new TareaFundido(i);
            resultadosFundir.add(exFundir.submit(fundido));
        }

        int numFundidos = 0;
        for (int i = 0; i < resultadosFundir.size(); i++){
            try{
                if (resultadosFundir.get(i).get()){
                    numFundidos++;
                    if (numFundidos == 9){
                        TareaForjado task = new TareaForjado();
                        exForjar.submit(task);
                    }
                }
            } catch (InterruptedException e){}
        }
    }
}
