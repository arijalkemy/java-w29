package repositories;


import models.Localizador;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorRepositoryImpl implements LocalizadorRepository {
    private final List<Localizador> localizadores = new ArrayList<>();

    @Override
    public void guardar(Localizador localizador) {
        this.localizadores.add(localizador);
    }

    @Override
    public List<Localizador> buscarPorCliente(Integer clienteId) {
        return this.localizadores.stream()
                .filter(loc -> loc.getCliente().getId().equals(clienteId))
                .toList();
    }

    @Override
    public List<Localizador> buscarTodos() {
        return this.localizadores;
    }


}
