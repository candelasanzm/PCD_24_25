package Teoria.Presentacion4.Ejercicio3.Monitores;

public class Pedido {
    private int idCliente;
    private int numLlaves;
    private Boolean listo = false;

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

    public Boolean getListo() {
        return listo;
    }

    public void setListo(Boolean listo) {
        this.listo = listo;
    }
}
