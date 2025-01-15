package org.example.model;

import java.util.Map;
import java.util.stream.Collectors;

public class DescuentoPorReservasRepetidas implements Descuentos {

        @Override
        public void aplicar(Localizador localizador) {
            Map<String, Long> conteo = localizador.getReservas().stream()
                    .collect(Collectors.groupingBy(Reserva::getType, Collectors.counting()));
            conteo.forEach((tipo, cantidad) -> {
                if ((tipo.equals("Hotel") || tipo.equals("Boleto")) && cantidad >= 2) {
                    localizador.aplicarDescuento(5);
                }
            });
        }
}
