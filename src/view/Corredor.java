package view;

import java.util.concurrent.Semaphore;
import controller.Pessoa;

public class Corredor {
    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(1); // Apenas uma pessoa pode cruzar a porta por vez

        String[] nomes = {"Ana", "Bruno", "Carlos", "Diana"};
        
        for (String nome : nomes) {
            new Pessoa(nome, semaforo).start();
        }
    }
}
