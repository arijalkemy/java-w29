import domain.Cliente;
import domain.Factura;
import domain.Item;

import java.util.*;

public class Supermercado {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("12345678", "Juan", "Pérez"));
        clientes.add(new Cliente("23456789", "María", "García"));
        clientes.add(new Cliente("11223344", "Carlos", "López"));

        System.out.println("Lista de clientes:");
        clientes.forEach(System.out::println);

        System.out.println("\nEliminando al cliente con DNI '23456789'");
        clientes.removeIf(cliente -> cliente.getDni().equals("23456789"));

        System.out.println("\nClientes restantes:");
        clientes.forEach(System.out::println);


        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngresar DNI del cliente que desea buscar: ");
        String dniBusqueda = scanner.nextLine();

        Optional<Cliente> clienteEncontrado = clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dniBusqueda)).findFirst();

        if (clienteEncontrado.isPresent()) {
            System.out.println("\nCliente encontrado: " + clienteEncontrado.get());
        } else {
            System.out.println("\nEl cliente con DNI " + dniBusqueda + " no se encuentra en la lista.");
        }

        // Parte 2

        List<Item> productos = Arrays.asList(
                new Item("P001", "Arroz", 0, 50),
                new Item("P002", "Fideos", 0, 40),
                new Item("P003", "Azúcar", 0, 30)
        );

        System.out.print("\nIngrese el DNI del cliente asociado a la factura: ");
        String dniCliente = scanner.nextLine();

        Cliente cliente = buscarCliente(clientes, dniCliente).orElse(null);

        if (cliente == null) {
            System.out.print("El cliente no está registrado. Ingrese el nombre del cliente: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el apellido del cliente: ");
            String apellido = scanner.nextLine();

            cliente = new Cliente(dniCliente, nombre, apellido);
            clientes.add(cliente);
            System.out.println("Cliente creado y agregado a la lista.");
        }


        List<Item> itemsFactura = new ArrayList<>();
        String continuar;
        do {
            System.out.println("\nProductos disponibles:");
            for (Item producto : productos) {
                System.out.println(producto);
            }

            System.out.print("\nIngrese el código del producto: ");
            String codigoProducto = scanner.nextLine();

            Optional<Item> productoSeleccionado = buscarProducto(productos, codigoProducto);

            if (productoSeleccionado.isPresent()) {
                System.out.print("Ingrese la cantidad comprada: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine();

                itemsFactura.add(new Item(productoSeleccionado.get().getCodigo(), productoSeleccionado.get().getNombre(), cantidad, productoSeleccionado.get().getCostoUnitario()));
            } else {
                System.out.println("Producto no encontrado.");
            }

            System.out.print("¿Desea agregar otro producto? (s/n): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("s"));


        List<Factura> facturas = new ArrayList<>();
        Factura nuevaFactura = new Factura(cliente, itemsFactura);
        facturas.add(nuevaFactura);

        System.out.println("\nFactura creada exitosamente:");
        System.out.println(nuevaFactura);

        System.out.println("\nListado de facturas:");
        for (Factura factura : facturas) {
            System.out.println(factura);
        }
    }

    private static Optional<Cliente> buscarCliente(List<Cliente> clientes, String dni) {
        return clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dni)).findFirst();
    }

    private static Optional<Item> buscarProducto(List<Item> productos, String codigo) {
        return productos.stream()
                .filter(item -> item.getCodigo().equals(codigo)).findFirst();
    }
}
