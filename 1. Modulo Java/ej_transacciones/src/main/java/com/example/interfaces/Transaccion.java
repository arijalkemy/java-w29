package com.example.interfaces;

public interface Transaccion {
    default void transaccionOk() {
        System.out.println("Transacción exitosa");
    };

    default void transaccionNoOk(String razon) {
        System.out.println("Ocurrió un error: " + razon);
    };
}