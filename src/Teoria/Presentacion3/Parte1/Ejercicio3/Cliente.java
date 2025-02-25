package Teoria.Presentacion3.Parte1.Ejercicio3;

public class Cliente extends Thread{
    private int clienteID;
    Tienda tienda;

    public Cliente(int clienteID, Tienda tienda){
        this.clienteID = clienteID;
        this.tienda = tienda;
    }

    public void run(){
        int prendas = (int) (Math.random() * 5);

        if (prendas > 0){
            tienda.probarRopa(clienteID, prendas);
            tienda.pagar(clienteID, prendas);
        }
    }
}
