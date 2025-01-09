import model.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void eliminarCliente(String dni, List<Cliente> clientes) {
        System.out.println("eliminando cliente");
        clientes.removeIf(c -> c.getDni().equals(dni));
    }

    public static void buscarCliente(String dni, List<Cliente> clientes) {
        for(Cliente c : clientes){
            if(c.getDni().equals(dni)){
                System.out.println(c.toString());
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>(Arrays.asList(
                new Cliente("43673423","Lucas","Quintana"),
                new Cliente("45693423","Pedro","lopez"),
                new Cliente("42342423","Juan","Perez")
        ));

        clientes.stream().forEach(System.out::println);

        //Elimino clientes
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el DNI del cliente a borrar: ");
        String dniABorrar = sc.nextLine();
        eliminarCliente(dniABorrar,clientes);

        //Vuelvo a imprimir
        for(Cliente c : clientes){
            System.out.println(c.toString());
        }

        //Buscar cliente
        String dniABuscar = sc.nextLine();
        System.out.println("Digite el DNI del cliente a buscar: ");
        buscarCliente("42342423",clientes);

        clientes.stream().
    }
}