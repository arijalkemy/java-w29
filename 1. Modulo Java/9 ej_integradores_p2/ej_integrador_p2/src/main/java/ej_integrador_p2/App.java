package ej_integrador_p2;

import java.util.*;
import ej_integrador_p2.models.*;
import ej_integrador_p2.repository.ClientImp;
import ej_integrador_p2.repository.FacturaImp;

public class App {
  static ClientImp client_imp = new ClientImp();
  static FacturaImp factura_imp = new FacturaImp();
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    App.addclientes();
    App.printAllClientes();
    App.findCliente();
    App.deleteCliente();
    App.addFactura();
  }

  private static void addclientes() {
    client_imp.save(new Cliente("1234", "Juan"));
    client_imp.save(new Cliente("8765", "Pedro"));
    client_imp.save(new Cliente("4565", "Maria"));
    System.out.println("3 clientes creados");
  }

  private static void printAllClientes() {
    client_imp.findAll().stream().forEach(System.out::println);
  }

  private static void findCliente() {
    System.out.println("Ingrese DNI a buscar");
    String dni = App.scanner.next();
    Optional<Cliente> cliente = client_imp.findById(dni);
    if (cliente.isPresent()) System.out.println("Cliente encontrado: " + cliente.get());
    else System.out.println("Cliente no encontrado");
  }

  private static void deleteCliente() {
    System.out.println("Ingrese DNI a borrar");
    String dni = App.scanner.next();
    client_imp.delete(dni);
    System.out.println("Lista de usuarios despues de borrar");
    client_imp.findAll().stream()
      .forEach(System.out::println);
  }

  private static void addFactura() {
    factura_imp.save(new Factura(
      new Cliente("0987", "edward"),
      List.of(
        new Item(0, "cereal", 100, 100.0),
        new Item(1, "pan", 32, 230.0)
      )
    ));
    factura_imp.findAll().stream()
      .forEach(System.out::println);
    System.out.println("Lista de usuario con usuario creado al crear la factura");
    client_imp.findAll().stream()
      .forEach(System.out::println);
  }
}