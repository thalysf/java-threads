package com.framework.execution;

public class Task implements Runnable {
    private final String mensagem;

    public Task(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + mensagem);
    }
}