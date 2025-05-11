package Teoria.Presentacion8.Ejercicio3;

import java.rmi.Naming;
import java.util.ArrayList;

public class Cliente {
    public static void main(String[] args) {
        try {
            SorteoRMI sorteoRMI = (SorteoRMI) Naming.lookup("//127.0.0.1/RealizarSorteoRMI");

            // Sorteo Euromillones
            System.out.println("Crear una nueva combinación para Euromillones");
            ArrayList<Integer> combinacionEuromillones = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                int numero = (int)(Math.random() * 10) + 1;
                combinacionEuromillones.add(numero);
            }

            System.out.println("Combinación Euromillones: " + combinacionEuromillones);
            sorteoRMI.nuevoSorteo("Euromillones", combinacionEuromillones);

            System.out.println("Comprueba la combinación ganadora de Euromillones");
            ArrayList<Integer> ganadorEuromillones = sorteoRMI.getSorteo("Euromillones");
            System.out.println("La combinación ganadora del sorteo de Euromillones es: " + ganadorEuromillones);

            System.out.println("Compruebo si he ganado el sorteo de Euromillones");
            if (sorteoRMI.comprobarSorteo("Euromillones", combinacionEuromillones)){
                System.out.println("He ganado el sorteo de Euromillones");
            } else {
                System.out.println("No se ha ganado el sorteo de Euromillones");
            }

            // Sorteo Primitiva
            System.out.println("Crear una nueva combinación para la Primitiva");
            ArrayList<Integer> combinacionPrimitiva = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                int numero = (int)(Math.random() * 10) + 1;
                combinacionPrimitiva.add(numero);
            }

            System.out.println("Combinación Primitiva: " + combinacionPrimitiva);
            sorteoRMI.nuevoSorteo("Primitiva", combinacionPrimitiva);

            System.out.println("Comprueba la combinación ganadora de la Primitiva");
            ArrayList<Integer> ganadorPrimitiva = sorteoRMI.getSorteo("Primitiva");
            System.out.println("La combinación ganadora del sorteo de Primitiva es: " + ganadorPrimitiva);

            System.out.println("Compruebo si he ganado la Primitiva");
            if (sorteoRMI.comprobarSorteo("Primitiva", combinacionPrimitiva)){
                System.out.println("He ganado el sorteo de la Primitiva");
            } else {
                System.out.println("No se ha ganado el sorteo de la Primitiva");
            }

            // Sorteo Bonoloto
            System.out.println("Crear una nueva combinación para el Bonoloto");
            ArrayList<Integer> combinacionBonoloto = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                int numero = (int)(Math.random() * 10) + 1;
                combinacionBonoloto.add(numero);
            }

            System.out.println("Combinación Bonoloto: " + combinacionBonoloto);
            sorteoRMI.nuevoSorteo("Bonoloto", combinacionBonoloto);

            System.out.println("Comprueba la combinación ganadora de Bonoloto");
            ArrayList<Integer> ganadorBonoloto = sorteoRMI.getSorteo("Bonoloto");
            System.out.println("La combinación ganadora del sorteo de Bonoloto es: " + ganadorBonoloto);

            System.out.println("Compruebo si he ganado el Bonoloto");
            if (sorteoRMI.comprobarSorteo("Bonoloto", combinacionBonoloto)){
                System.out.println("He ganado el sorteo de la Bonoloto");
            } else {
                System.out.println("No se ha ganado el sorteo de la Bonoloto");
            }
        } catch (Exception e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
