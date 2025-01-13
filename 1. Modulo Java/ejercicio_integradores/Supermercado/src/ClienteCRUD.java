import java.util.List;

public class ClienteCRUD implements Crud<Cliente> {

    @Override
    public void create(Cliente object) {
        Cliente cliente = new Cliente(object.dni, object.nombre, object.apellido);
        System.out.println("se creo el cliente: " + cliente);
    }

    @Override
    public void update(List<Cliente> lista, Cliente  object) {
        object.setDni(object.dni);
        object.setNombre(object.nombre);
        object.setApellido(object.apellido);
    }

    @Override
    public void delete() {

    }

    @Override
    public void read() {

    }
}
