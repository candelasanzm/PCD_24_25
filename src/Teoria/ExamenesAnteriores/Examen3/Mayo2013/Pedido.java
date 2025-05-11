package Teoria.ExamenesAnteriores.Examen3.Mayo2013;

public class Pedido {
    public Pedido(){}

    public int lineaPedidoNueva(String nombre, int cantidad, int precio){
        if (nombre.length() > 20 || cantidad < 1 || cantidad > 1000 || precio < 1 || precio > 1000){
            return -1;
        }
        System.out.println("Pedido Registrado. Nombre: " + nombre + ", cantidad: " + cantidad + ", precio: " + precio);
        return 1;
    }
}
