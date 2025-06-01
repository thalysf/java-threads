package com.framework.timer;

public class Timer {
    public static void main(String[] args) {
        // Cria um Timer
        java.util.Timer timer = new java.util.Timer();

        // Define uma tarefa para ser executada após 2 segundos
        timer.schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                System.out.println("Tarefa executada após 2 segundos");
            }
        }, 2000);

        // Continua executando outras tarefas enquanto aguarda
        for (int i = 0; i < 5; i++) {
            System.out.println("Executando outra tarefa " + (i + 1));
            try {
                Thread.sleep(500); // Simula trabalho enquanto aguarda
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Agora executamos o timer com um delay recorente de 1 segundo
        timer.scheduleAtFixedRate(new java.util.TimerTask() {
            @Override
            public void run() {
                System.out.println("Tarefa recorrente executada a cada 1 segundo");
            }
        }, 0, 1000);

        // Cancela o timer se necessário
        // timer.cancel();
    }
}
