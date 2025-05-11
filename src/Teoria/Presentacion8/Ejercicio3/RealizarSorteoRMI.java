package Teoria.Presentacion8.Ejercicio3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RealizarSorteoRMI extends UnicastRemoteObject implements SorteoRMI {
    private ArrayList<Integer> sorteoEuromillones;
    private ArrayList<Integer> sorteoPrimitiva;
    private ArrayList<Integer> sorteoBonoloto;

    public RealizarSorteoRMI() throws RemoteException {
        sorteoEuromillones = new ArrayList<>();
        sorteoPrimitiva = new ArrayList<>();
        sorteoBonoloto = new ArrayList<>();
    }

    @Override
    public ArrayList<Integer> getSorteo(String sorteo) throws RemoteException {
        ArrayList<Integer> ganador = new ArrayList<>();

        switch (sorteo) {
            case "Euromillones": ganador = sorteoEuromillones;
            case "Primitiva": ganador = sorteoPrimitiva;
            case "Bonoloto": ganador = sorteoBonoloto;
        }

        System.out.println("La combinación ganadora es " + sorteo + ": " + ganador.toString());
        return ganador;
    }

    @Override
    public boolean comprobarSorteo(String sorteo, ArrayList<Integer> combinacion) throws RemoteException {
        boolean esGanador = true;
        ArrayList<Integer> ganador = new ArrayList<>();

        switch (sorteo) {
            case "Euromillones": ganador = sorteoEuromillones;
            case "Primitiva": ganador = sorteoPrimitiva;
            case "Bonoloto": ganador = sorteoBonoloto;
        }

        if (combinacion == ganador){
            esGanador = false;
        }

        if (esGanador){
            System.out.println("La combinación dada es la combinación ganadora");
        } else {
            System.out.println("La combinación dada no es la combinación ganadora");
        }

        return esGanador;
    }

    @Override
    public void nuevoSorteo(String sorteo, ArrayList<Integer> combinacion) throws RemoteException {
        System.out.println("Nueva combinación del sorteo " + sorteo + ": " + combinacion);

        switch (sorteo) {
            case "Euromillones": sorteoEuromillones = combinacion;
            case "Primitiva": sorteoPrimitiva = combinacion;
            case "Bonoloto": sorteoBonoloto = combinacion;
        }
    }
}
