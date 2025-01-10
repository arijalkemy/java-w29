package repositories;


import models.Localizador;

import java.util.List;

public interface LocalizadorRepository {
    void guardar(Localizador localizador);
    List<Localizador> buscarPorCliente(Integer clienteId);
    List<Localizador> buscarTodos();
}
