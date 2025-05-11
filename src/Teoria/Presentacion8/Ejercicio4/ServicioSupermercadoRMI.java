package Teoria.Presentacion8.Ejercicio4;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServicioSupermercadoRMI extends UnicastRemoteObject implements SupermercadoRMI {
    public ServicioSupermercadoRMI() throws RemoteException {}

    public int procesarPedido(int idTrabajador, int cantidadProductos, int precioTotal) throws RemoteException{
        if (idTrabajador < 1 || idTrabajador > 1000 || cantidadProductos < 1 || cantidadProductos > 1000 || precioTotal < 1 || precioTotal > 1000){
            System.out.println("Pedido inválido: idTrabajador = " + idTrabajador + ", cantidadProductos = " + cantidadProductos + ", precioTotal = " + precioTotal);
            return -1;
        }
        System.out.println("Pedido procesado: idTrabajador = " + idTrabajador + ", cantidadProductos = " + cantidadProductos + ", precioTotal = " + precioTotal);
        return 1;
    }
}
