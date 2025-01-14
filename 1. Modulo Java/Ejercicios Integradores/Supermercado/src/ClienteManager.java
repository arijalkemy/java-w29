import java.util.ArrayList;
import java.util.List;

public class ClienteManager implements Crud<Cliente> {

    private List<Cliente> clientes;

    public ClienteManager() {
        clientes = new ArrayList<>();
    }

    @Override
    public void crear(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente consultar(String dni) {
        Cliente cliente = clientes.stream()
                .filter(c -> c.getDni().equals(dni))
                .findFirst()
                .orElse(null);
        if (cliente == null) {
            System.out.println("No se encontró un cliente con el DNI: " + dni);
            return null;
        }
        else{
            System.out.println("Cliente encontrado, el cliente con el DNI: " + dni + " es: " + cliente);
            return cliente;
        }

    }

    @Override
    public void actualizar(Cliente cliente, String dni) {
        Cliente encontrado = consultar(dni);
        if (encontrado != null) {
            int index = clientes.indexOf(encontrado);
            clientes.set(index, cliente);
            System.out.println("Actualizacion realizada exitosamente");
            System.out.println("Cliente anterior: " + encontrado);
            System.out.println("Cliente actualizado: " + cliente);
        }
        else{
            System.out.println("Cliente no encontrado");
        }
    }

    @Override
    public void eliminar(String dni) {
        boolean eliminado = clientes.removeIf(cliente -> cliente.getDni().equals(dni));
        if (!eliminado) {
            System.out.println("No se encontró ningún cliente con el DNI: " + dni);
        }
        else{
            System.out.println("Cliente: " + dni +" eliminado");
        }
    }

    public void imprimirClientes() {
        clientes.forEach(System.out::println);
    }
}