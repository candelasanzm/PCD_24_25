package Teoria.Presentacion4.Ejercicio3.Semaforos;

public class MainOpcional2 {
    public static void main(String[] args) {
        ServicioLlaves servicioLlaves = new ServicioLlaves();
        TrabajadorOpcional2 trabajadorOpcional2 = new TrabajadorOpcional2(servicioLlaves);
        trabajadorOpcional2.start();

        for (int i = 0; i < 20; i++){
            Cliente cliente = new Cliente(servicioLlaves, i);
            cliente.start();
        }
    }
}
