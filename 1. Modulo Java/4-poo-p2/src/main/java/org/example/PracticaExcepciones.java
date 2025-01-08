package org.example;

public class PracticaExcepciones {
    private int a;
    private int b;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int calcularCociente(){
        return b / a;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
