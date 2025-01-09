package com.thiagoschreck.local.agencia;

public record Reserva(double valor, Tipo tipo) {
    public enum Tipo {
        HOTEL,
        COMIDA,
        BOLETO,
        TRANSPORTE
    }

    @Override
    public String toString() {
        return String.format("%s - Valor: $%s", tipo.toString(), valor);
    }
}
