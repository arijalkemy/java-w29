package org.example.model;

import java.util.Set;
import java.util.stream.Collectors;

class DescuentoPaqueteCompleto implements Descuentos {

    private Set<String> types = Set.of("Hotel", "Boleto", "Comida", "Transporte");

    @Override
    public void aplicar(Localizador localizador) {
        Set<String> tiposEnReserva = localizador.getReservas()
                .stream()
                .map(Reserva::getType)
                .collect(Collectors.toSet());

        if (tiposEnReserva.containsAll(types)) {
            localizador.aplicarDescuento(10);
        }
    }
}
