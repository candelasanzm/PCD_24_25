package Teoria.Presentacion4.Ejercicio3.Monitores;

import static java.lang.Thread.sleep;

public class MainOpcional2 {
    public static void main(String[] args) {
        Taller taller = new Taller();
        TrabajadorOpcional2 trabajadorOpcional2 = new TrabajadorOpcional2(taller);
        trabajadorOpcional2.start();

        for (int i = 0; i < 21; i++){
            Cliente cliente = new Cliente(taller, i);
            cliente.start();
            try {
                sleep(2000);
            } catch (Exception e){}
        }
    }
}
