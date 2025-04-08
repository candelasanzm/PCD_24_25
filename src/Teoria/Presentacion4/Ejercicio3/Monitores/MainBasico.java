package Teoria.Presentacion4.Ejercicio3.Monitores;

import static java.lang.Thread.sleep;

public class MainBasico {
    public static void main(String[] args) {
        Taller taller = new Taller();
        TrabajadorBasico trabajadorBasico = new TrabajadorBasico(taller);
        trabajadorBasico.start();

        for (int i = 0; i < 21; i++){
            Cliente cliente = new Cliente(taller, i);
            cliente.start();
            try {
                sleep(500);
            } catch (Exception e){}
        }
    }
}
