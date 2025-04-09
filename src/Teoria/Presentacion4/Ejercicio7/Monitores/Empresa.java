package Teoria.Presentacion4.Ejercicio7.Monitores;

import java.util.Date;

public class Empresa {
    private int totalCafes = 0;
    private int numeroTrabajadores = 0;
    private boolean cafeteraOcupada = false;
    private boolean ficharOcupado = false;

    public Empresa() {}

    public synchronized void fichar(int iD, boolean entra){
        try{
            while (ficharOcupado){
                wait();
            }
            ficharOcupado = true;
            if (entra) {
                numeroTrabajadores++;
                System.out.println("Trabajador ID: " + iD + ", Hora de entrada: " + new Date() + ". Trabajadores fichados: " + numeroTrabajadores);
                Thread.sleep(1000);
            } else {
                numeroTrabajadores--;
                System.out.println("Trabajador ID: " + iD + ", Hora de salida: " + new Date() + ". Trabajadores dentro: " + numeroTrabajadores);
                Thread.sleep(1000);
            }
            ficharOcupado = false;
            notifyAll();
        } catch(Exception e){}
    }

    public synchronized void prepararCafe(){
        try {
            while (cafeteraOcupada){
                wait();
            }
            cafeteraOcupada = true;
            totalCafes++;
            System.out.println("Total de cafés preparados: " + totalCafes);
            Thread.sleep(5000);
            cafeteraOcupada = false;
            notifyAll();
        } catch (Exception e) {}
    }

    public void trabajar(int id){
        try{
            int tiempoTrabajo = 2 + (int)(Math.random() * 1);
            System.out.println("El trabajador id: " + id + " trabaja durante " + tiempoTrabajo + " segundos");
            Thread.sleep(tiempoTrabajo);
        } catch (Exception e) {}
    }
}
