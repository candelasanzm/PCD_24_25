package Teoria.ExamenesAnteriores.Examen2.Examen201516.Ejercicio3;

public class Jugador extends Thread {
    private String nombre;
    private Campo campo;

    public Jugador(int id, Campo campo) {
        this.nombre = String.valueOf(id);
        this.campo = campo;
    }

    public String getNombre() {
        return nombre;
    }

    public void run(){
        try {
            campo.llegadaPista(this);

            if(campo.esArbitro(this)){
                campo.asignarEquiposArbitro(this);
                System.out.println("Arranca el partido");
                Thread.sleep(3000);
                System.out.println("Árbitro pita el final del partido");
                campo.finalizarPartido(this);
            } else {
                campo.elegirEquipoJugador(this);
                System.out.println("Jugador " + nombre + " esperando a que se inicie el partido");
                campo.finalizarPartido(this);
                System.out.println("Jugador " + nombre + " termina el partido");
            }
        } catch (Exception e){
            System.out.println("Error en los jugadores " + e.toString());
        }
    }
}
