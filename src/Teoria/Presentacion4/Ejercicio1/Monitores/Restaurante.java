package Teoria.Presentacion4.Ejercicio1.Monitores;

public class Restaurante {
    private int maxComandas;
    private String[] comandas;
    private int numElementos = 0;
    private int in = 0;
    private int out = 0;

    public Restaurante(int maxComandas) {
        this.maxComandas = maxComandas;
        comandas = new String[maxComandas];
    }

    public synchronized void dejarComanda(String comanda) throws InterruptedException {
        while (numElementos == maxComandas) {
            System.out.println("La estantería está llena");
            wait();
        }

        comandas[in] = comanda;
        numElementos++;
        in = (in + 1) % maxComandas;
        System.out.println("Se añadió la comanda " + comanda);
        notifyAll();
    }

    public synchronized String cogerComanda() throws InterruptedException {
        while (numElementos == 0){
            System.out.println("Estantería vacía");
            wait();
        }

        String comanda = comandas[out];
        comandas[out] = null;
        numElementos--;
        out = (out + 1) % maxComandas;
        notifyAll(); // hay hueco
        return comanda;
    }
}
