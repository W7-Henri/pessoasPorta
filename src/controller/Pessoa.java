package controller;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Pessoa extends Thread {
    private String nome;
    private Semaphore semaforo;
    private int velocidade;
    private static final int DISTANCIA = 200;

    public Pessoa(String nome, Semaphore semaforo) {
        this.nome = nome;
        this.semaforo = semaforo;
        this.velocidade = new Random().nextInt(3) + 4; // Velocidade entre 4 e 6 m/s
    }

    @Override
    public void run() {
        try {
            int tempoPercurso = DISTANCIA / velocidade * 1000; // Converter para milissegundos
            System.out.println(nome + " está caminhando no corredor...");
            Thread.sleep(tempoPercurso);
            
            semaforo.acquire(); // Apenas uma pessoa pode cruzar a porta por vez
            System.out.println(nome + " chegou à porta e está atravessando...");
            Thread.sleep(new Random().nextInt(1001) + 1000); // Tempo de 1 a 2 segundos para cruzar
            System.out.println(nome + " atravessou a porta!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
    }
}
