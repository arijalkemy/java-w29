package com.thiagoschreck.local.series_numericas;

public class Stringcrementador extends Incrementador {

    public Stringcrementador(String valorSerie) {
        super(valorSerie == null || valorSerie.isBlank() ? 0 : Integer.parseInt(valorSerie));
    }
}
