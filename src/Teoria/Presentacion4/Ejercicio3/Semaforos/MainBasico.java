package Teoria.Presentacion4.Ejercicio3.Semaforos;

public class MainBasico {
    public static void main(String[] args) {
        ServicioLlaves servicioLlaves = new ServicioLlaves();
        TrabajadorBasico trabajadorBasico = new TrabajadorBasico(servicioLlaves);
        trabajadorBasico.start();

        for (int i = 0; i < 20; i++){
            Cliente cliente = new Cliente(servicioLlaves, i);
            cliente.start();
        }
    }
}
