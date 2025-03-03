package Teoria.ExamenesAnteriores.Examen1.PECT1_22_23.OtraForma;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class Edificio {
    Lock aula = new ReentrantLock();
    Lock maquina1 = new ReentrantLock();
    Lock maquina2 = new ReentrantLock();
    Lock bano = new ReentrantLock();
    private int usosMaquina1 = 0;
    private int usosMaquina2 = 0;
    private int numEstudiantesAula1 = 0;
    private int numEstudiantesAula2 = 0;

    public void llegar (int id){
        try {
            System.out.println("El estudiante " + id + " ha llegado");
            sleep(500);
        } catch (InterruptedException e) {}
    }

    public void aula (int id, int numAula, boolean entra){
        aula.lock();
        try{
            if (numAula == 1){
                if (entra){
                    numEstudiantesAula1++;
                    System.out.println("El estudiante " + id + " ha entrado en el aula 1 en la fecha " + new Date() + ". Total de estudiantes en el aula 1: " + numEstudiantesAula1);
                    sleep(1000);
                } else {
                    numEstudiantesAula1--;
                    System.out.println("El estudiante " + id + " ha salido del aula 1 en la fecha " + new Date() + ". Total de estudiantes en el aula 1: " + numEstudiantesAula1);
                    sleep(1000);
                }
            } else if (numAula == 2){
                if (entra){
                    numEstudiantesAula2++;
                    System.out.println("El estudiante " + id + " ha entrado en el aula 2 en la fecha " + new Date() + ". Total de estudiantes en el aula 2: " + numEstudiantesAula2);
                    sleep(1000);
                } else {
                    numEstudiantesAula2--;
                    System.out.println("El estudiante " + id + " ha salido del aula 2 en la fecha " + new Date() + ". Total de estudiantes en el aula 2: " + numEstudiantesAula2);
                    sleep(1000);
                }
            }
        } catch (InterruptedException e) {
        } finally {
            aula.unlock();
        }
    }

    public void usarMaquina1 (int id){
        maquina1.lock();
        try{
            usosMaquina1 ++;
            System.out.println("El estudiante " + id + " usa la máquina de cafe. Total de pedidos a la máquina: " + usosMaquina1);
            sleep(5000);
        } catch (InterruptedException e) {
        } finally {
            maquina1.unlock();
        }
    }

    public void usarMaquina2 (int id){
        maquina2.lock();
        try{
            usosMaquina2 ++;
            System.out.println("El estudiante " + id + " usa la máquina expendedora. Total de pedidos a la máquina: " + usosMaquina2);
            sleep(5000);
        } catch (InterruptedException e) {
        } finally {
            maquina2.unlock();
        }
    }

    public void bano (int id){
        bano.lock();
        try {
            System.out.println("El estudiante " + id + " va al baño");
            sleep(3000);
        } catch (InterruptedException e) {
        } finally {
            bano.unlock();
        }
    }
}
