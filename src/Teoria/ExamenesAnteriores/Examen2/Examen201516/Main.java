package Teoria.ExamenesAnteriores.Examen2.Examen201516;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService exDoblar = Executors.newFixedThreadPool(7);
        ExecutorService exEmpaquetar = Executors.newFixedThreadPool(5);

        ArrayList<Future<Boolean>> resultadosDoblar = new ArrayList<>();

        for (int i = 0; i < 500; i++){
            Prenda prenda = new Prenda(i % 5);
            TareaDoblado doblar = new TareaDoblado(i, prenda);
            resultadosDoblar.add(exDoblar.submit(doblar));
        }

        int numTipo1 = 0;
        int numTipo2 = 0;
        int numTipo3 = 0;
        int numTipo4 = 0;
        int numTipo5 = 0;
        for (int i = 0; i < resultadosDoblar.size(); i++){
            try{
                if (resultadosDoblar.get(i).get().isDoblado()){
                    switch (resultadosDoblar.get(i).get().getTipo()){
                        case 1:
                            numTipo1 ++;
                            if (numTipo1 == 5){
                                TareaEmpaquetado tarea = new TareaEmpaquetado();
                                exEmpaquetar.submit(tarea);
                                numTipo1 = 0;
                            }
                            break;
                        case 2:
                            numTipo2 ++;
                            if (numTipo2 == 5){
                                TareaEmpaquetado tarea = new TareaEmpaquetado();
                                exEmpaquetar.submit(tarea);
                                numTipo2 = 0;
                            }
                            break;
                        case 3:
                            numTipo3 ++;
                            if (numTipo3 == 5){
                                TareaEmpaquetado tarea = new TareaEmpaquetado();
                                exEmpaquetar.submit(tarea);
                                numTipo3 = 0;
                            }
                            break;
                        case 4:
                            numTipo4 ++;
                            if (numTipo4 == 5){
                                TareaEmpaquetado tarea = new TareaEmpaquetado();
                                exEmpaquetar.submit(tarea);
                                numTipo4 = 0;
                            }
                            break;
                        case 5:
                            numTipo5 ++;
                            if (numTipo5 == 5){
                                TareaEmpaquetado tarea = new TareaEmpaquetado();
                                exEmpaquetar.submit(tarea);
                                numTipo5 = 0;
                            }
                            break;
                    }
                }
            }
        }
    }
}
