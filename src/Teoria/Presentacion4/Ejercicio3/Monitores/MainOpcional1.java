package Teoria.Presentacion4.Ejercicio3.Monitores;

import static java.lang.Thread.sleep;

public class MainOpcional1 {
    public static void main(String[] args) {
        Taller taller = new Taller();
        TrabajadorOpcional1 trabajadorOpcional1 = new TrabajadorOpcional1(taller);
        trabajadorOpcional1.start();

        for (int i = 0; i < 21; i++){
            Cliente cliente = new Cliente(taller, i);
            cliente.start();
            try {
                sleep(500);
            } catch (Exception e){}
        }
    }
}
