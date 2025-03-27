package Laboratorio.Sesion3.Ejemplo1;

/*
 La clase Buzon tiene que estar protegida con un cerrojo
 El método enviaMensaje debe esperar si el buzón está lleno
 El método recibeMensaje debe esperar si el buzón está vacío.
 Cuando un hilo completa su operación, desbloquea a los que estén esperando
 para que puedan continuar intentando su acción.
*/

public class Buzon {
    private String mensaje;
    private boolean hayMensaje = false;

    public void enviaMensaje(String msg) {
        hayMensaje = true;
        mensaje = msg;
    }

    public String recibeMensaje() {
        hayMensaje = false;
        return mensaje;
    }
}
