package Laboratorio.Sesion5.Ejemplo;

import javax.swing.*;
import java.util.ArrayList;

public class ListaThreads {
    ArrayList<Visitante> lista;
    JTextField tf;

    public ListaThreads(JTextField tf) {
        lista=new ArrayList<Visitante>();
        this.tf=tf;
    }

    public synchronized void meter(Visitante t) {
        lista.add(t);
        imprimir();
    }

    public synchronized void sacar(Visitante t) {
        lista.remove(t);
        imprimir();
    }

    public void imprimir() {
        String contenido="";
        for(int i=0; i<lista.size(); i++) {
            contenido=contenido+lista.get(i).getMiId()+" ";
        }
        tf.setText(contenido);
    }
}
