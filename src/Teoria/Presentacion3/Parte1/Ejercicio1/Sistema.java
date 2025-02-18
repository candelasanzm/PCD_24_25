package Teoria.Presentacion3.Parte1.Ejercicio1;

public class Sistema {
    int temp1, temp2, temp3 = 0;
    String display = "";

    public Sistema() {
    }

    public void escribir(int valor, int id){
        switch(id){
            case 1:
                temp1 = valor;
                break;
            case 2:
                temp2 = valor;
                break;
            case 3:
                temp3 = valor;
                break;
        }
    }

    public void media(){
        int media = (temp1 + temp2 + temp3) / 3;
        display = "Temperatura = " + media;
    }
}
