package supermercado.repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository <T>{
    public void guardar (T obj);
    public void mostrarPorPantalla();
    public Optional<T> buscar(Long id);
    public void eliminar(Long id);
    public List<T> traerTodos();
}
