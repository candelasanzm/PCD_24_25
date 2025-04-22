package Teoria.ExamenesAnteriores.Examen2.Examen202122;

public class Main {
    public static void main(String[] args) {
        Comedero comedero = new Comedero();
        Aguila aguila = new Aguila(comedero);
        aguila.start();

        int avesESP_A = 0, avesESP_INV = 0;
        for (int i = 0; i < 200; i++){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){}

            String tipo = (avesESP_A < 100) ? "ESP-A" : "ESP-INV";
            Ave ave = new Ave(i, tipo, comedero);
            ave.start();

            if (tipo.equals("ESP-A")){
                avesESP_A++;
            } else {
                avesESP_INV++;
            }
        }

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e){}

        comedero.imprimirResultados(200);
    }
}
