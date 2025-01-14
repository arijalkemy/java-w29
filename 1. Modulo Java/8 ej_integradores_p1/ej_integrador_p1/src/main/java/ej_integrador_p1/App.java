package ej_integrador_p1;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) {
    Cliente.clientes.add(new Cliente("1234", "Juan"));
    Cliente.clientes.add(new Cliente("8765", "Pedro"));
    Cliente.clientes.add(new Cliente("4565", "Maria"));
    System.out.println("3 clientes creados");
    Cliente.clientes.stream().forEach(System.out::println);
    Cliente.clientes.removeIf(cliente -> cliente.getDni().equals("8765"));
    System.out.println("Despues de borrar");
    Cliente.clientes.stream().forEach(System.out::println);
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese DNI a buscar");
    String dni = scanner.next();
    scanner.close();
    Cliente cliente = Cliente.clientes.stream()
      .filter(client -> client.getDni().equals(dni))
      .findFirst()
      .orElse(null);
    if (cliente != null) System.out.println("Cliente encontrado: " + cliente);
    else System.out.println("Cliente no encontrado");
  }
}
