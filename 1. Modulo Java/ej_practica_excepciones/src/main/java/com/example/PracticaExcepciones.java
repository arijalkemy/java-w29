package com.example;

public class PracticaExcepciones {
    private final int a;

    private final int b;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public double calcularCociente() {
        return b / a;
    }
}

