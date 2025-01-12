package Repository;

import Models.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements CRUD<Cliente> {

    private List<Cliente> clientes;

    public ClienteRepository() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void create(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            cliente.setId(clientes.size() + 1);
            clientes.add(cliente);
            System.out.println("Cliente adicionado com sucesso");
        }else{
            System.out.println("El cliente ya se encuentra registrado");
        }
    }

    @Override
    public void delete(Integer id) {
        this.clientes.removeIf(cliente -> cliente.getId() == id);
    }

    @Override
    public Cliente get(Integer id) {
        return this.clientes.stream().filter(cliente -> cliente.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Cliente> getAll() {
        return this.clientes;
    }




}
