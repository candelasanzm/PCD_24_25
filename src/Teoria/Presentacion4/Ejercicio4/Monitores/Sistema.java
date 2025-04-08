package Teoria.Presentacion4.Ejercicio4.Monitores;

public class Sistema {
    private int max = 10;
    private int[] display = new int[max];
    private int count = 0;
    private int in = 0;

    public Sistema() {}

    public synchronized void escribir(int valor, int id) throws InterruptedException {
        if (count == max) {
            wait();
        }
        display[in] = valor;
        in = (in + 1) % max;
        count++;
        System.out.println("Sensor " + id + " escribe valor " + valor);
        notifyAll(); // se han escrito nuevos datos
    }

    public synchronized void media() throws InterruptedException {
        while (count < max){
            wait();
        }
        int suma = 0;
        for (int i = 0; i < max; i++) {
            suma += display[i];
        }
        int media = suma / max;
        System.out.println("Temperatura media: " + media);
        count = 0;
        in = 0;
        notifyAll();
    }
}
