package Laboratorio.Sesion1.Ejercicio7;

public class Bicho extends Thread{
    private int generacion;
    private String nombre;
    private int generacionFinal = 5;
    long tiempoVida;

    public Bicho(int generacion, String nombre) {
        this.generacion = generacion;
        this.nombre = nombre;
        // Lanzar el mensaje NACE
        System.out.println("NACE: " + nombre + ", generacion: " + generacion);
    }

    public void run() {
        try {
            // Esperar un tiempo aleatorio
            int tiempo = 500 + (int)(Math.random() * 500);
            sleep(tiempo);

            if (generacion < generacionFinal) {
                // Crea un nuevo bicho hijo
                String nombreHijo = generarNombreAleatorio();
                Bicho bichoHijo = new Bicho(generacion + 1, nombreHijo);
                bichoHijo.start();

                // Esperar a que el hijo acabe (muera)
                bichoHijo.join();
            }

            tiempoVida = tiempo;

            // Mensaje muere
            System.out.println("MUERE: " + nombre + ", generacion: " + generacion + ", tiempo de vida: " + tiempoVida + " miliseg");

        } catch (InterruptedException e) {}
    }

    private String generarNombreAleatorio() {
        char[] letras = new char[4];
        for (int i = 0; i < 4; i++) {
            letras[i] = (char) ('A' + (int)(Math.random() * 26));
        }
        return new String(letras);
    }
}
