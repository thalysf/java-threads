package com.framework.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SchedulerExecutorService {
    // main for ScheduledExecutorService
    public static void main(String[] args) {
        // Cria um ScheduledExecutorService com 1 thread
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Agenda uma tarefa para ser executada após 2 segundos
        scheduler.schedule(() -> {
            System.out.println("Tarefa agendada executada após 2 segundos");
        }, 2, TimeUnit.SECONDS);

        // Agenda uma tarefa recorrente para ser executada a cada 1 segundo
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Tarefa recorrente executada a cada 1 segundo");
        }, 0, 1, TimeUnit.SECONDS);

        // Continua executando outras tarefas enquanto aguarda
        for (int i = 0; i < 5; i++) {
            System.out.println("Executando outra tarefa " + (i + 1));
            try {
                Thread.sleep(500); // Simula trabalho enquanto aguarda
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Exemplo de uso de ScheduledFuture para obter o resultado de uma tarefa agendada
         ScheduledFuture<Object> resultFuture = scheduler.schedule(() -> "Tarefa Agendada Finalizada!!!", 5, TimeUnit.SECONDS);
        try {
            // Bloqueia até que a tarefa agendada seja concluída e obtém o resultado
            Object result = resultFuture.get();
            System.out.println("Resultado da tarefa agendada: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Cancela o scheduler se necessário
        // scheduler.shutdown();
    }
}
