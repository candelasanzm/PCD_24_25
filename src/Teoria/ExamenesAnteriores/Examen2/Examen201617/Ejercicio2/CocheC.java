package Teoria.ExamenesAnteriores.Examen2.Examen201617.Ejercicio2;

public class CocheC extends Thread{
    private Carrera carrera;

    public CocheC(Carrera carrera) {
        this.carrera = carrera;
    }

    public void run(){
        try{
            carrera.esperar();
            carrera.arrancaCarrera();
            Thread.sleep(5000);
            carrera.finalizarCarrera();
        } catch (Exception e){}
    }
}
