package Laboratorio.Sesion5.Ejercicio2;

public class Visitante extends Thread {
    private Exposicion expo;
    private int id;

    public Visitante(int id, Exposicion expo) {
        super.setName(String.valueOf(id));
        this.expo=expo;
        this.id=id;
    }

    public int getMiId() {
        return id;
    }

    public void run() {
        try {
            sleep((int)(3000*Math.random()));
        } catch (InterruptedException e){ }

        while (expo.getDetener()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){ }
        }

        expo.entrar(this); //Entra en la exposición, si hay hueco; y sino espera en la cola
        expo.mirar(this); //Está un tiempo dentro de la exposición
        expo.salir(this); //Sale de la exposición
    }
}
