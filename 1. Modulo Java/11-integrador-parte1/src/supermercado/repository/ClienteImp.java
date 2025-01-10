package supermercado.repository;

import supermercado.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CRUDRepository<Cliente>{

    List<Cliente> clientes = new ArrayList<>();

    @Override
    public void guardar(Cliente obj) {
        clientes.add(obj);
    }

    @Override
    public void mostrarPorPantalla() {
        clientes.forEach(System.out::println);
    }

    @Override
    public Optional<Cliente> buscar(Long id) {
        Cliente c = (Cliente) clientes.stream()
                .filter(cliente -> cliente.getDni().equals(id))
                .findFirst()
                .orElse(null);
        return Optional.ofNullable(c);
    }

    @Override
    public void eliminar(Long id) {
        Optional<Cliente> c = this.buscar(id);
        if(c.isEmpty()){
            System.out.println("No existe cliente con ese dni.");

        } else {
            clientes.remove(c.get());
            System.out.println("Cliente con dni: " + id + " ha sido eliminado.");
        }
    }

    @Override
    public List<Cliente> traerTodos() {
        return clientes;
    }
}
