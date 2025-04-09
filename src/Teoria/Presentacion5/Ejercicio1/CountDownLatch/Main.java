package Teoria.Presentacion5.Ejercicio1.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        Taller taller = new Taller();

        TrabajadorEnPruebas trabajadorEnPruebas = new TrabajadorEnPruebas(taller);
        TrabajadorVeterano trabajadorVeterano = new TrabajadorVeterano(taller);
        trabajadorEnPruebas.start();
        trabajadorVeterano.start();

        for (int i = 0; i <= 20; i++){
            Cliente cliente = new Cliente(taller, i);
            cliente.start();
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
