package Teoria.ExamenesAnteriores.Examen2.Examen201516;

import java.util.concurrent.Callable;

public class TareaDoblado implements Callable {
    private int id;
    private Prenda prenda;

    public TareaDoblado(int id, Prenda prenda) {
        this.id = id;
        this.prenda = prenda;
    }

    @Override
    public Prenda call() throws Exception {
        try{

        }
    }
}
