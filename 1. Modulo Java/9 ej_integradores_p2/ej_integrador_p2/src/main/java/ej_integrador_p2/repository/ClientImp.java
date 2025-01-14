package ej_integrador_p2.repository;

import java.util.*;

import ej_integrador_p2.models.Cliente;

public class ClientImp implements Crud<Cliente> {
  private static List<Cliente> clientes = new ArrayList<>();

  public static void create(Cliente cliente){
    clientes.add(cliente);
  }

  public static Optional<Cliente> find(String dni){
    return clientes.stream()
      .filter(client -> client.getDni().equals(dni))
      .findFirst(); 
  }

  @Override
  public void save(Cliente t) {
    clientes.add(t);
  }

  @Override
  public Optional<Cliente> findById(String dni){
    return clientes.stream()
      .filter(client -> client.getDni().equals(dni))
      .findFirst(); 
  }

  @Override
  public List<Cliente> findAll(){
    return clientes;
  }

  @Override
  public void update(String dni) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void delete(String dni) {
    Optional<Cliente> cliente = this.findById(dni);
    if(cliente.isEmpty()) System.out.println("No se encontro el cliente");
    else clientes.remove(cliente.get());
  }
}
