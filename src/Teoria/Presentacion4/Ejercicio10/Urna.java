package Teoria.Presentacion4.Ejercicio10;

public class Urna {
    private int candidato1 = 0;
    private int candidato2 = 0;
    private int candidato3 = 0;
    private int total = 0;

    public Urna(){}

    public synchronized void votar(int voto) throws InterruptedException{
        switch(voto){
            case 1:
                candidato1++;
                break;
            case 2:
                candidato2++;
                break;
            case 3:
                candidato3++;
                break;
        }

        total++;

        if(total == 80){
            notifyAll();
            mostrarResultado();
        }
    }

    public synchronized void mostrarResultado() throws InterruptedException{
        while(total < 80){
            wait();
        }

        System.out.println("Recuento de votos");
        System.out.println("Candidato 1: " + candidato1);
        System.out.println("Candidato 2: " + candidato2);
        System.out.println("Candidato 3: " + candidato3);

        int ganador = Math.max(candidato1, Math.max(candidato2, candidato3));

        if((ganador == candidato1 && ganador == candidato2 || ganador == candidato1 && ganador == candidato3 || ganador == candidato2 && ganador == candidato3)){
            System.out.println("Empate");
        }else if (ganador == candidato1){
            System.out.println("Ganador: Candidato 1");
        }else if(ganador == candidato2){
            System.out.println("Ganador: Candidato 2");
        }else{
            System.out.println("Ganador: Candidato 3");
        }
    }
}
