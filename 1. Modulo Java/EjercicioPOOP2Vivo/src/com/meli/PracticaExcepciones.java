package com.meli;

public class PracticaExcepciones {
    int a;
    int b;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void execute() {

        try {
            if (a == 0) {
                throw new IllegalArgumentException("El argumento no puede ser 0");
            }
            this.dividir();
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    private void dividir() {
        double coeficiente = b / a;
    }


}
