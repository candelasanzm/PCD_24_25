package Teoria.Presentacion4.Ejercicio5.Monitores;

public class Urna {
    private int candidato1 = 0;
    private int candidato2 = 0;
    private int candidato3 = 0;
    private int total = 0;
    private int votos = 0;
    private int max;

    public Urna(int max){
        this.max = max;
    }

    public synchronized void votar(int voto) throws InterruptedException{
        while(votos == max){
            wait();
        }

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
        votos++;

        if(votos == max || total == 80){
            notifyAll();
        }
    }

    public synchronized boolean vaciarUrna() throws InterruptedException{
        while(votos < max || total < 80){
            wait();
        }
        System.out.println("Encargado recoge la urna");
        System.out.println("Candidato 1: " + candidato1);
        System.out.println("Candidato 2: " + candidato2);
        System.out.println("Candidato 3: " + candidato3);
        votos = 0;
        notifyAll();
        return total < 80;
    }

    public void ganador(){
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
