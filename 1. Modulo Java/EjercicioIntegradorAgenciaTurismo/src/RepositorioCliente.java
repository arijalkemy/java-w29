import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RepositorioCliente {
    private final Map<String, Cliente> clientes;

    public RepositorioCliente() {
        this.clientes = new HashMap<>();
    }

    public Cliente obtenerCliente(String nombre) {
        return clientes.getOrDefault(nombre, null);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.putIfAbsent(cliente.getNombre(), cliente);
    }

    public Collection<Cliente> getClientes() {
        return clientes.values();
    }
}
