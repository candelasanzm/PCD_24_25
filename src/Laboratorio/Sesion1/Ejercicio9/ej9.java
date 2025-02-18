package Laboratorio.Sesion1.Ejercicio9;

public class ej9 {
    public static void main(String[] args) {
        for (int i = 1; i < 1001; i++){
            int id = i;
            Thread thread = new Thread(() -> {
                System.out.println("Hilo ID: " + id);
            });
            thread.start();
        }
    }
}

// Los hilos no se ejecutaron secuencialmente en el orden en el que se crearon