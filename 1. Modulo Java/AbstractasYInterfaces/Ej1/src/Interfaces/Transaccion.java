package Interfaces;

public interface Transaccion {
    static void transaccionOk() {
        System.out.println("Realizándose transacción");
    }

    static void transaccionNoOk() {
        System.out.println("Transacción fallida");
    }
}
