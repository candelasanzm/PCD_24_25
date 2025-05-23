package Teoria.Presentacion5.Ejercicio4.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        final int totalEstudiantes = 80;
        final int capacidadUrna = 40;

        Urna urna = new Urna(totalEstudiantes, capacidadUrna);

        Estudiante[] estudiantes = new Estudiante[totalEstudiantes];
        for (int i = 0; i < totalEstudiantes; i++) {
            estudiantes[i] = new Estudiante(i, urna);
            estudiantes[i].start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Estudiante estudiante : estudiantes) {
            try {
                estudiante.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        urna.mostrarGanador();
    }
}
