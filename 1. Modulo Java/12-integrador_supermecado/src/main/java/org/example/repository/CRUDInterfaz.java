package org.example.repository;

import java.util.List;
import java.util.Optional;

public interface CRUDInterfaz <T>{

    public void save (T t);
    public void mostrarPorPantalla();
    public Optional<T> buscarPorDni(String dni);
    public Optional<T> buscarPorID(Integer id);
    public void eliminar(Integer id);
    public List<T> trearTodos();
}
