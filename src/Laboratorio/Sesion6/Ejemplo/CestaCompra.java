package Laboratorio.Sesion6.Ejemplo;

public class CestaCompra {
    private String nombreCliente;
    private int[] carroCompra;

    public CestaCompra(String nombreCliente, int[] carroCompra) {
        this.nombreCliente = nombreCliente;
        this.carroCompra = carroCompra;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public int[] getCarroCompra() {
        return carroCompra;
    }
}
