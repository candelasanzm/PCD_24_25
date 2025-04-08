package Teoria.Presentacion6.Ejercicio5;

import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class TareaFundido implements Callable {
    private int id;

    public TareaFundido(int id){
        this.id = id;
    }

    @Override
    public Boolean call() throws Exception {
        try{
            sleep(500);
            System.out.println("Se ha transportado el material " + id);
            sleep(500);
            System.out.println("Se ha fundido " + id);
        } catch (Exception e){
            System.out.println("Error al fundir");
        }
        return true;
    }
}
