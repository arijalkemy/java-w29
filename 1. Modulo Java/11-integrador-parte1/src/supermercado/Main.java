package supermercado;

import supermercado.model.Cliente;
import supermercado.repository.ClienteImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClienteImp clienteImp = new ClienteImp();
        Cliente a = new Cliente(1234L, "Selena", "Gomez");
        Cliente b = new Cliente(5678L, "Jennifer", "Aniston");
        Cliente c = new Cliente(9012L, "Salma", "Hayek");
        // 2.
        clienteImp.guardar(a);
        clienteImp.guardar(b);
        clienteImp.guardar(c);
        // 3.
        clienteImp.mostrarPorPantalla();
        // 4.
        Scanner entrada = new Scanner(System.in);
        System.out.println("\nBuscar cliente por dni: ");
        Long dniBuscado = entrada.nextLong();
        Optional<Cliente> buscado = clienteImp.buscar(dniBuscado);
        if(buscado.isPresent()){
            System.out.println(buscado);
        } else {
            System.out.println("No existe cliente con ese dni.");
        }

        // 5.
        System.out.println("\nIngrese el dni del cliente a eliminar: ");
        Long dniEliminado = entrada.nextLong();
        clienteImp.eliminar(dniEliminado);



        /*
        // 2.
        List<Cliente> clientes = new ArrayList<>(List.of(
                new Cliente(1234L, "Selena", "Gomez"),
                new Cliente(5678L, "Jennifer", "Aniston"),
                new Cliente(9012L, "Salma", "Hayek")
        ));

        clientes.forEach(System.out::println);

        // 3. eliminar un cliente por dni
        Scanner entrada = new Scanner(System.in);
        System.out.println("\nIngrese el dni del cliente a eliminar: ");
        Long dniEliminado = entrada.nextLong();
        Cliente eliminado = (Cliente) clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dniEliminado))
                .findFirst()
                .orElse(null);
        if(eliminado != null){
            clientes.remove(eliminado);
            System.out.println("Cliente con dni: " + dniEliminado + " ha sido eliminado.");
        } else {
            System.out.println("No existe cliente con ese dni.");
        }

        // 4. buscar cliente
        System.out.println("\nBuscar cliente por dni: ");
        Long dniBuscado = entrada.nextLong();
        Cliente buscado = (Cliente) clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dniBuscado))
                .findFirst()
                .orElse(null);
        if(buscado != null){
            System.out.println(buscado);
        } else {
            System.out.println("No existe cliente con ese dni.");
        }*/
    }
}