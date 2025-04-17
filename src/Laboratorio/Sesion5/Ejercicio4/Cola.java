package Laboratorio.Sesion5.Ejercicio4;

import javax.swing.*;
import java.util.ArrayList;

public class Cola {
    ArrayList<Thread> lista;
    JTextField tf;

    public Cola(JTextField tf) {
        lista = new ArrayList<Thread>();
        this.tf = tf;
    }

    public synchronized void meter(Thread t) {
        lista.add(t);
        imprimir();
    }

    public synchronized void sacar(Thread t) {
        lista.remove(t);
        imprimir();
    }

    public void imprimir() {
        String contenido = "";
        for(int i = 0; i < lista.size(); i++)
        {
            contenido = contenido + ((Vehiculo)lista.get(i)).getNum() + " ";
        }
        tf.setText(contenido);
    }
}
