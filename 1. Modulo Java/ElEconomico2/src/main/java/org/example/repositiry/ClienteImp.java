package org.example.repositiry;

import org.example.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CRUDRepository<Cliente> {

    List<Cliente> listaClientes = new ArrayList<Cliente>();

    @Override
    public void save(Cliente object) {
        listaClientes.add(object);
    }

    @Override
    public void mostrarPantalla() {
        for (Cliente c : listaClientes) {
            System.out.println("Dni = " + c.getDni());
            System.out.println("Nombre = " + c.getNombre());
            System.out.println("Apellido = " + c.getApellido());
        }
    }

    @Override
    public Optional<Cliente> buscar(Long dniBuscado) {


        boolean bandera = false;
        for (Cliente c : listaClientes) {
            if (c.getDni().equals(dniBuscado)) {
                System.out.println("------------- Cliente encontrado, sus datos son: ---------");
                System.out.println("DNI = " + c.getDni());
                System.out.println("Nombre = " + c.getNombre());
                System.out.println("Apellido = " + c.getApellido());
                return Optional.of(c);
            }
        }

        if (bandera==false) {
            System.out.println("El cliente no se ha encontrado");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(Long dniBorrado) {

    Optional<Cliente> cli = this.buscar(dniBorrado);

        if (cli.isEmpty()) {
            System.out.println("El cliente a eliminar no existe");
        }else {
            System.out.println("El cliente se a eliminado");
            listaClientes.remove(cli.get());
        }
    }

    @Override
    public List<Cliente> traerTodos() {
        return List.of();
    }
}
