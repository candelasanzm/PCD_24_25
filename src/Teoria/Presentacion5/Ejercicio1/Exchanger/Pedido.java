package Teoria.Presentacion5.Ejercicio1.Exchanger;

public class Pedido {
    private int idCliente;
    private int numLlaves;
    private boolean listo = false;

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

    public boolean isListo(){
        return listo;
    }

    public void setListo(boolean listo) {
        this.listo = listo;
    }
}
