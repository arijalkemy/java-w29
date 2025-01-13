import java.util.*;


public class Main {
    public static void main(String[] args) {

        System.out.println("----Parte 1----");
        Cliente clienteEliminado = new Cliente(123123123,"Camilo", "Sanchez");
        Cliente cliente2 = new Cliente(678967889,"pedro", "Hernandez");
        Cliente cliente3 = new Cliente(321312321,"Juan", "Alvarez");
        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(clienteEliminado);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        System.out.println("----Mostrar datos de todos los clientes----");
        listaClientes.forEach(System.out::println);

        System.out.println("----Eliminando un cliente----");
        listaClientes.remove(clienteEliminado);
        System.out.println("----Verificando que el cliente esta eliminado----");
        listaClientes.forEach(System.out::println);

        System.out.println("----Filtrar cliente con DNI----");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el dni del cliente: ");
        Integer dni = sc.nextInt();
        List<Cliente> filtrarCliente = listaClientes.stream().filter(cliente -> Objects.equals(cliente.getDni(), dni)).toList();
        if (filtrarCliente.size() > 0) {
            System.out.println(filtrarCliente);
        }else{
            System.out.println("El cliente no existe");
        }

        System.out.println("----Parte 2 ----");
        Item item1 = new Item(111d, "Arroz", 10d,2d);
        Item item2 = new Item(112d, "Pasta", 20d,1d);
        Item item3 = new Item(113d, "Zanahoria", 20d,3d);
        Item item4 = new Item(114d, "Rabano", 15d,8d);

        List<Item> items1 = Arrays.asList(item1, item2, item3);
        List<Item> items2 = Arrays.asList(item1, item2, item3, item4);
        Cliente clienteNuevo = new Cliente(2312312,"adam", "Metido");
        Factura factura1 = new Factura(clienteNuevo,items1);
        Factura factura2 = new Factura(cliente2,items2);
        System.out.println(factura1.toString());

        System.out.println("----validacion de cliente antes de agregar a la factura----");
        if (listaClientes.contains(factura1.cliente)){
            System.out.println("cliente ya existe");
        }else{
            listaClientes.add(factura1.cliente);
        }
        System.out.println(listaClientes);







    }
}