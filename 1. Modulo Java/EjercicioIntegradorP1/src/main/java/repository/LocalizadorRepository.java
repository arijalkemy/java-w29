package repository;

import model.Localizador;

import java.util.List;

public class LocalizadorRepository {
    List<Localizador> localizadores;

    public void save() {

    }

    public void add(Localizador localizador) {
        localizadores.add(localizador);
    }
}
