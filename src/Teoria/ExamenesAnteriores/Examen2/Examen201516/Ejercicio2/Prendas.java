package Teoria.ExamenesAnteriores.Examen2.Examen201516.Ejercicio2;

public class Prendas {
    private String[] tiposPrendas = {"camisa", "pantalón", "camiseta", "falda", "chaqueta"};
    private String tipoString;
    private int tipoPrenda;
    private Boolean doblada;

    public Prendas(){
        tipoPrenda = (int)(Math.random() * 4);
        tipoString = tiposPrendas[tipoPrenda];
        doblada = false;
    }

    public String getTipoString() {
        return tipoString;
    }

    public void setTipoString(String tipoString) {
        this.tipoString = tipoString;
    }

    public int getTipoPrenda() {
        return tipoPrenda;
    }

    public void setTipoPrenda(int tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }

    public Boolean getDoblada() {
        return doblada;
    }

    public void setDoblada(Boolean doblada) {
        this.doblada = doblada;
    }
}
