package Teoria.Presentacion4.Ejercicio3.Semaforos;

public class MainOpcional1 {
    public static void main(String[] args) {
        ServicioLlaves servicioLlaves = new ServicioLlaves();
        TrabajadorOpcional1 trabajadorOpcional1 = new TrabajadorOpcional1(servicioLlaves);
        trabajadorOpcional1.start();

        for (int i = 0; i < 20; i++){
            Cliente cliente = new Cliente(servicioLlaves, i);
            cliente.start();
        }
    }
}
