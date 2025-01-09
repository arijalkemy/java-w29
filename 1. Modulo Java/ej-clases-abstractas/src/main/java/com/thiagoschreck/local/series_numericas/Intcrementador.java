package com.thiagoschreck.local.series_numericas;

import static java.util.Objects.isNull;

public class Intcrementador extends Incrementador {

    public Intcrementador(Integer valorSerie) {
        super(isNull(valorSerie) ? 0 : valorSerie);
    }
}
