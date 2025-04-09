package Teoria.Presentacion4.Ejercicio9;

public class Sistema {
    private int max = 10;
    private int[] display = new int[max];
    int count = 0;
    int in = 0;

    public Sistema(){}

    public synchronized void escribir(int valor, int id) throws InterruptedException {
        if(count == max){
            wait(); // está lleno
        }
        display[in] = valor;
        in = (in + 1) % max;
        count++;
        System.out.println("Sensor " + id + " escribe valor " + valor);
        notifyAll();  //se han escrito nuevos datos
    }

    public synchronized void media() throws InterruptedException {
        while (count == 0) {
            wait();  //Espera a que haya datos
        }
        int suma = 0;
        for(int i = 0; i < max; i++){
            suma += display[i];
        }
        int media = suma / max;
        System.out.println("Temperatura media: " + media);
        //vaciar
        count = 0;
        in = 0;
        notifyAll();
    }
}
