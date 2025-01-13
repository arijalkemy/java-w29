import Modelos.Cliente;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = List.of(
                new Cliente("39999999", "Pepe", "Lopez"),
                new Cliente("40000000", "Juan", "Gonzales"),
                new Cliente("40000001", "Camila", "Perez")
        );

        System.out.println("Recorrido de clientes");
        imprimir(clientes);

        System.out.println("Recorrido de clientes al remover 'Pepe'");
        clientes = clientes
                .stream()
                .filter(it -> !it.getNombre().equals("Pepe"))
                .collect(Collectors.toList());

        imprimir(clientes);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresar DNI del cliente a buscar");
        String input = scanner.nextLine();

        clientes
                .stream()
                .filter(it -> it.getDni().equals(input))
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Cliente no encontrado")
                );


    }

    private static void imprimir(List<Cliente> clientes) {
        clientes.forEach(System.out::println);
    }
}