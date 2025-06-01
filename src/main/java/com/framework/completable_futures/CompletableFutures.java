package com.framework.completable_futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutures {
    public static void main(String[] args) {
        // Cria um CompletableFuture que completa assincronamente
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000); // Simula processamento demorado
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Resultado da tarefa assíncrona";
        });

        // Define o que fazer quando o resultado estiver pronto
        future.thenAccept(result -> {
            System.out.println("Recebido: " + result);
        });

        // Bloqueia apenas para demonstração (não faça isso em produção!)
        try {
            future.get(); // Espera a conclusão
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Codigo corrente que pode continuar executando enquanto aguarda o resultado
        for (int i = 0; i < 5; i++) {
            System.out.println("Executando outra tarefa " + (i + 1));
            try {
                Thread.sleep(200); // Simula trabalho enquanto aguarda
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}