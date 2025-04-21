package Teoria.ExamenesAnteriores.Examen2.Examen201516.Ejercicio2;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        // Crear los pools
        ExecutorService exDoblado = Executors.newFixedThreadPool(5);
        ExecutorService exEmpaquetado = Executors.newFixedThreadPool(3);

        ArrayList<Integer> numDoblados = new ArrayList<>();
        numDoblados.add(0);
        numDoblados.add(0);
        numDoblados.add(0);
        numDoblados.add(0);
        numDoblados.add(0);

        // Almacenar los resultados de las tareas de doblado
        ArrayList<Future<Prendas>> arrayOutputDoblado = new ArrayList<>();

        // Mandar todas las prendas a doblar
        for (int i = 0; i < 200; i++){
            Prendas prendas = new Prendas();
            Future<Prendas> outputDoblado = exDoblado.submit(new TareaDoblado(i, prendas));
            arrayOutputDoblado.add(outputDoblado);
        }

        // Comprobar las prendas dobladas y empaquetarlas
        for (int i = 0; i < 200; i++){
            try {
                Future<Prendas> prendaDoblada = arrayOutputDoblado.get(i);
                if(prendaDoblada.get().getDoblada()){
                    // Actualizar el número de prendas dobladas
                    numDoblados.set(prendaDoblada.get().getTipoPrenda(), numDoblados.get(prendaDoblada.get().getTipoPrenda() + 1));
                    // Comprobar que se pueden empaquetar
                    if (numDoblados.get(prendaDoblada.get().getTipoPrenda()) == 5){
                        exEmpaquetado.execute(new TareaEmpaquetado(prendaDoblada.get().getTipoString()));
                        numDoblados.set(prendaDoblada.get().getTipoPrenda(), numDoblados.get(prendaDoblada.get().getTipoPrenda() - 5));
                    }
                }
            } catch (Exception e){
                System.out.println("Error al generar la tarea de empaquetado " + e.toString());
            }
        }

        exDoblado.shutdown();
        exEmpaquetado.shutdown();
    }
}
