package com.thiagoschreck.local.agencia;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorRepository {
    private static final List<Localizador> localizadores = new ArrayList<>();

    public static void addLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }

    public static List<Localizador> getLocalizadoresByCliente(Cliente cliente) {
        return localizadores.stream()
                .filter(localizador -> localizador.getCliente().equals(cliente))
                .toList();
    }

    public static List<Localizador> getLocalizadores() {
        return localizadores;
    }
}
