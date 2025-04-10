package Laboratorio.Sesion6.Ejemplo;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainExecutor {
    private static final int numCajeras = 2;
    private static final int numClientes = 8;
    private static final int numProductos = 5;

    public static void main(String[] args) {
        ArrayList<CestaCompra> cestas = new ArrayList<CestaCompra>();
        for(int i=0; i<numClientes; i++) {
            int[] productos = new int[numProductos];
            for(int j=0; j<numProductos; j++) {
                productos[j]=(int) (Math.random()*3+1); //Valores entre 1 y 4
            }
            cestas.add(new CestaCompra("Cliente "+(i+1), productos));
        }

        ExecutorService executor = Executors.newFixedThreadPool(numCajeras);

        for (int i = 0; i < cestas.size(); i++) {
            TareaCajera tarea = new TareaCajera(cestas.get(i));
            executor.execute(tarea);
        }

        executor.shutdown();  // Voy terminando el pool

        try {
            // Espero a que terminen de ejecutarse todas las tareas para pasar a las siguientes instrucciones
            executor.awaitTermination(24, TimeUnit.HOURS);
        } catch (InterruptedException ex) {}
    }
}
