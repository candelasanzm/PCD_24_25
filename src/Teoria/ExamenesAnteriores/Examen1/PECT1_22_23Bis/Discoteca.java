package Teoria.ExamenesAnteriores.Examen1.PECT1_22_23Bis;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class Discoteca {
    Lock puerta = new ReentrantLock();
    ArrayList<Lock> barra = new ArrayList();
    ArrayList<Lock> servicios = new ArrayList();
    private int mayoresEdad = 0;
    private int menoresEdad = 0;
    private int numPedidosBarra1 = 0;
    private int numPedidosBarra2 = 0;

    public Discoteca() {
        for (int i = 0; i < 2; i++) {
            servicios.add(new ReentrantLock());
            barra.add(new ReentrantLock());
        }
    }

    private void esperar(int segundos) {
        try {
            sleep(segundos * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void acceso(int id, int edad, boolean entra) {
        puerta.lock();
        try {
            if (entra) {
                if (edad < 18) {
                    menoresEdad++;
                } else {
                    mayoresEdad++;
                }
                System.out.println("Persona con id " + id + " de edad " + edad + " entra en la discoteca. Cantidad de personas mayores de edad dentro: " + mayoresEdad + ". Cantidad de personas menores de edad dentro: " + menoresEdad);
                esperar(2);
            } else {
                if (edad < 18) {
                    menoresEdad--;
                } else {
                    mayoresEdad--;
                }
                System.out.println("Persona con id " + id + " de edad " + edad + " sale de la discoteca. Cantidad de personas mayores de edad dentro: " + mayoresEdad + ". Cantidad de personas menores de edad dentro: " + menoresEdad);
                esperar(2);
            }
        } catch (Exception e) {
        } finally {
            puerta.unlock();
        }
    }

    public void barra(int barraId, int id) {
        boolean atendido = false;
        long tiempoLimite = new Date().getTime() + 5000;

        while (new Date().getTime() < tiempoLimite && !atendido) {
            for (int i = 0; i < barra.size(); i++) {
                if (barra.get(i).tryLock()) {
                    try {
                        if (barraId == 1) {
                            numPedidosBarra1++;
                            System.out.println("Pedido atendido en la barra " + barraId + " en la fecha " + new Date() + ". Total de pedidos atendidos en la barra " + barraId + " hasta el momento: " + numPedidosBarra1);
                        } else {
                            numPedidosBarra2++;
                            System.out.println("Pedido atendido en la barra " + barraId + " en la fecha " + new Date() + ". Total de pedidos atendidos en la barra " + barraId + " hasta el momento: " + numPedidosBarra2);
                        }
                        atendido = true;
                        esperar(5);
                        break;
                    } catch (Exception e) {
                    } finally {
                        barra.get(i).unlock();
                    }
                }
            }

            if (!atendido) {
                System.out.println("El usuario " + id + " ha alcanzado el tiempo limite de espera en la barra y se va");
            }
        }
    }

    public void servicio(int id){
        try {
            for (int i = 0; i < servicios.size(); i++) {
                try {
                    if (servicios.get(i).tryLock()) {
                        System.out.println("El usuario " + id + " ha entrado al baño " + i);
                        esperar(4);
                    }
                } catch (Exception e) {
                } finally {
                    servicios.get(i).unlock();
                }
            }
        } catch (Exception e) {}
    }
}
