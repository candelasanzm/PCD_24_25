package Teoria.Presentacion4.Ejercicio3.Semaforos;

public class Pedido {
    private int idCliente;
    private int numLlaves;

    public Pedido(int idCliente, int numLlaves) {
        this.idCliente = idCliente;
        this.numLlaves = numLlaves;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getNumLlaves() {
        return numLlaves;
    }
}
