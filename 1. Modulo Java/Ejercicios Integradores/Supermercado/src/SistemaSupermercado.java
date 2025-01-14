import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaSupermercado {

    public static void main(String[] args) {
        ClienteManager clienteManager = new ClienteManager();
        List<Factura> facturas = new ArrayList<>();

        //Creacion de clientes
        clienteManager.crear(new Cliente("12345678A", "Juan", "Pérez"));
        clienteManager.crear(new Cliente("87654321B", "María", "González"));
        clienteManager.crear(new Cliente("11223344C", "Luis", "Martínez"));

        //Mostrar clientes
        System.out.println("Listado de clientes:");
        clienteManager.imprimirClientes();

        //Eliminar clientes
        System.out.println("\nPruebas de eliminacion:");
        clienteManager.eliminar("87654321B");
        clienteManager.eliminar("123456789");
        System.out.println("\nListado de clientes después de eliminación:");
        clienteManager.imprimirClientes();

        //Buscar cliente
        System.out.println("\nPruebas de busqueda:");
        clienteManager.consultar("123456789");
        clienteManager.consultar("11223344C");


        //Actualizar cliente
        System.out.println("\nPruebas de actualizacion:");
        Cliente clienteActualizar = new Cliente("12345678","Erik","Calvillo");
        clienteManager.actualizar(clienteActualizar,"11223344C");

        System.out.println("\nParte 2:");
        crearYRegistrarFactura(clienteManager, facturas);
    }

    private static void crearYRegistrarFactura(ClienteManager clienteManager, List<Factura> facturas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese el DNI del cliente para la nueva factura:");
        String dniCliente = scanner.nextLine();
        Cliente cliente = clienteManager.consultar(dniCliente);
        if (cliente == null) {
            System.out.println("El cliente no está registrado. Creación de nuevo cliente.");
            System.out.print("Nombre del nuevo cliente: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellido del nuevo cliente: ");
            String apellido = scanner.nextLine();
            cliente = new Cliente(dniCliente, nombre, apellido);
            clienteManager.crear(cliente);
        }
        List<Item> items = new ArrayList<>();
        System.out.println("Ingrese la cantidad de items:");
        int cantidadItems = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < cantidadItems; i++) {
            System.out.println("Datos del item " + (i + 1) + ":");
            System.out.print("Código: ");
            String codigo = scanner.nextLine();
            System.out.print("Nombre: ");
            String nombreItem = scanner.nextLine();
            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            System.out.print("Costo unitario: ");
            double costoUnitario = scanner.nextDouble();
            scanner.nextLine();
            items.add(new Item(codigo, nombreItem, cantidad, costoUnitario));
        }
        Factura factura = new Factura(cliente, items);
        facturas.add(factura);
        System.out.println("Factura creada exitosamente: " + factura);
    }
}