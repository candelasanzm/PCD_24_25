package Teoria.Presentacion8.Ejercicio5;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class OperacionesRMI extends UnicastRemoteObject implements InterfazRMI {
    private ArrayList<Integer> temperaturas;
    private ArrayList<Integer> humedades;

    public OperacionesRMI() throws RemoteException {
        temperaturas = new ArrayList<>();
        humedades = new ArrayList<>();
    }

    @Override
    public void enviarDatos(int temperatura, int humedad) throws RemoteException {
        temperaturas.add(temperatura);
        humedades.add(humedad);

        System.out.println("Datos recibidos: temperaturas = " + temperatura + ", humedad = " + humedad);

        if (temperaturas.size() == 10 && humedades.size() == 10) {
            calcularMedias(temperaturas, humedades);
            temperaturas.clear();
            humedades.clear();
        }
    }

    @Override
    public void calcularMedias(ArrayList<Integer> temperaturas, ArrayList<Integer> humedades) throws RemoteException {
        double mediaTemperatura = (double) (temperaturas.get(0) + temperaturas.get(1) + temperaturas.get(2) + temperaturas.get(3) + temperaturas.get(4) + temperaturas.get(5) + temperaturas.get(6) + temperaturas.get(7) + temperaturas.get(8) + temperaturas.get(9)) / 10;
        double mediaHumedades = (double) (humedades.get(0) + humedades.get(1) + humedades.get(2) + humedades.get(3) + humedades.get(4) + humedades.get(5) + humedades.get(6) + humedades.get(7) + humedades.get(8) + humedades.get(9)) / 10;
        System.out.println("Temperatura media: " + mediaTemperatura);
        System.out.println("Humedades media: " + mediaHumedades);
    }
}
