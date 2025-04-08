package Teoria.ExamenesAnteriores.Examen2.Examen201617.Ejercicio1;

public class Visitantes extends Thread{
    private Museo museo;

    public Visitantes(Museo museo){
        this.museo = museo;
    }

    public void run(){
        try {
            int entrada = (int) (Math.random() * 2);
            if(entrada == 0){
                museo.entrar_museo_este(this);
            } else {
                museo.entrar_museo_oeste(this);
            }
            sleep(5000);
            museo.salir_museo(this);
        } catch (Exception e){}
    }
}
