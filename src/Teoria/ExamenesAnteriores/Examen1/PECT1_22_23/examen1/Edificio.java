package Teoria.ExamenesAnteriores.Examen1.PECT1_22_23.examen1;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Edificio {
    private int numEstudiantesAula1 = 0;
    private int numEstudiantesAula2 = 0;
    private int usosMaquinaCafe = 0;
    private int usosMaquinaExpendedora = 0;
    private Lock aula = new ReentrantLock();
    private Lock maquina = new ReentrantLock();
    private Lock banio = new ReentrantLock();

    public Edificio(){}

    private void esperar(int segundos){
        try{
            Thread.sleep(segundos * 1000);
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void accesoAulas(int id, int numAula, boolean entra){
        aula.lock();
        try{
            if (numAula == 1){
                if (entra){
                    numEstudiantesAula1++;
                    System.out.println("El estudiante con id " + id + " entra en el aula " + numAula + " en la fecha " + new Date() + ". Total de estudiantes en el aula: " + numEstudiantesAula1);
                } else {
                    numEstudiantesAula1--;
                    System.out.println("El estudiante con id " + id + " sale del aula " + numAula + " en la fecha " + new Date() + ". Total de estudiantes en el aula: " + numEstudiantesAula1);
                }
                esperar(1);
            } else {
                if (entra){
                    numEstudiantesAula2++;
                    System.out.println("El estudiante con id " + id + " entra en el aula " + numAula + " en la fecha " + new Date() + ". Total de estudiantes en el aula: " + numEstudiantesAula2);
                } else {
                    numEstudiantesAula2--;
                    System.out.println("El estudiante con id " + id + " entra en el aula " + numAula + " en la fecha " + new Date() + ". Total de estudiantes en el aula: " + numEstudiantesAula2);
                }
                esperar(1);
            }
        } catch (Exception e){
        } finally {
            aula.unlock();
        }
    }

    public void usarMaquina(int id){
        int numMaquina = 1 + (int) (Math.random() * 2);

        maquina.lock();
        try{
            if (numMaquina == 1){
                usosMaquinaCafe++;
                System.out.println("El estudiante con id " + id + " usa la máquina de café. Total de usos de la máquina: " + usosMaquinaCafe);
            } else {
                usosMaquinaExpendedora++;
                System.out.println("El estudiante con id " + id + " usa la máquina expendedora. Total de usos de la máquina: " + usosMaquinaExpendedora);
            }
            esperar(5);
        } catch (Exception e){
        } finally {
            maquina.unlock();
        }
    }

    public void usarBanio(int id){
        banio.lock();
        try{
            System.out.println("El estudiante con id " + id + " usa el baño");
            esperar(3);
        } catch (Exception e){
        } finally {
            banio.unlock();
        }
    }
}
