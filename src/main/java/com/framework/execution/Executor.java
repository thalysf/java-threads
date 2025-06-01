package com.framework.execution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Executor {
    public static void main(String[] args) {
        // Primeiro executor (parallel)
        ExecutorService parallelExecutor = Executors.newFixedThreadPool(5);

        System.out.println("###############\nStarting tasks parallel...");
        for (int i = 1; i <= 5; i++) {
            parallelExecutor.submit(new Task("Parallel Task " + i));
        }

        parallelExecutor.shutdown();

        try {
            // Espera até que todas as tarefas do primeiro executor terminem
            parallelExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Segundo executor (single thread) - só inicia após o primeiro terminar
        ExecutorService singleThreadExecutor = Executors.newFixedThreadPool(1);

        System.out.println("###############\nStarting tasks single thread...");
        for (int i = 1; i <= 5; i++) {
            singleThreadExecutor.submit(new Task("Single Thread Task " + i));
        }

        singleThreadExecutor.shutdown();
    }
}
