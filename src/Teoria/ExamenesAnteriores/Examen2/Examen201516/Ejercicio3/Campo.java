package Teoria.ExamenesAnteriores.Examen2.Examen201516.Ejercicio3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;

public class Campo {
    private CyclicBarrier barrera; // 22 niños y 5 árbitros
    private CountDownLatch finPartido; // pitido final
    private Exchanger<String> exchanger; // intercambio de información entre árbitros y niños
    private ArrayList<Jugador> jugadores;
    private int numEquipo1, numEquipo2;
    private ArrayList<String> arbitros;

    public Campo(){
        barrera = new CyclicBarrier(27);
        finPartido = new CountDownLatch(1);
        exchanger = new Exchanger<>();
        jugadores = new ArrayList<>();
        numEquipo1 = 0;
        numEquipo2 = 0;
        arbitros = new ArrayList<>();
    }

    public void llegadaPista(Jugador jugador){
        try {
            System.out.println("Jugador " + jugador.getNombre() + " ha llegado a la pista");
            jugadores.add(jugador);
            barrera.await();

            if (jugadores.size() == 22){
                Collections.shuffle(jugadores);
                for (int i = 0; i < 5; i++){
                    arbitros.add(jugadores.get(i).getNombre());
                }
                System.out.println("Árbitros seleccionados " + arbitros);
            }
        } catch (InterruptedException e){
            System.out.println("InterruptedException en la barrera " + e.toString());
        } catch (BrokenBarrierException e){
            System.out.println("BrokenBarrierException en la barrera " + e.toString());
        }
    }

    public Boolean esArbitro(Jugador jugador){
        return arbitros.contains(jugador.getNombre());
    }

    // Método que va a asignar los equipos. Sólo lo va a ejecutar el árbitro.
    public void asignarEquiposArbitro(Jugador jugador) {
        if (esArbitro(jugador)) {
            return;
        }

        for (int i = 1; i < jugadores.size(); i++) {
            try {
                // Espera el mensaje del jugador
                String mensaje = exchanger.exchange(null);
                System.out.println("Arbitro recibe: " + mensaje);
                //Decidir con qué equipo va
                String equipo;
                if (numEquipo1 >= 11) {
                    equipo = "2";
                } else {
                    if (numEquipo2 >= 11) {
                        equipo = "1";
                    } else {
                        equipo = String.valueOf((int) (Math.random() * 2) + 1);
                    }
                }
                exchanger.exchange(equipo); // Responder con el rol
            } catch (InterruptedException ex) {
                System.out.println("Error al asignar un equipo por el arbitro: " + ex.toString());
            }
        }
    }

    // Método para elegir equipo. Se ejecutará por los jugadores. Usamos un monitor para que elijan de 1 en 1
    public synchronized String elegirEquipoJugador(Jugador jugador) {
        String equipo = "";
        try {
            //El jugador se ofrece a formar equipo
            exchanger.exchange("Soy el jugador " + jugador.getNombre() + ", con que equipo voy?");
            //Espera la respuesta del árbitro
            equipo = exchanger.exchange(""); // segundo intercambio: recibe equipo
            System.out.println("Jugador " + jugador.getNombre() + " ha sido asignado al " + equipo);
        } catch (InterruptedException ex) {
            System.out.println("Error al elegir un equipo el jugador: " + ex.toString());
        }
        return equipo;
    }

    //Método para finalizar el partido
    public void finalizarPartido(Jugador jugador) {
        try {
            if (esArbitro(jugador)) {
                finPartido.countDown(); // Señala el fin del partido para sincronizar a los jugadores
            } else {
                finPartido.await(); // Esperar a que el árbitro pite el final
            }
        } catch (InterruptedException ex) {
            System.out.println("Error al esperar el fin del partido: " + ex.toString());
        }
    }
}
