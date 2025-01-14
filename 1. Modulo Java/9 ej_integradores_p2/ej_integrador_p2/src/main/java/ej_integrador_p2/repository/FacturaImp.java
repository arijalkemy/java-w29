package ej_integrador_p2.repository;

import java.util.*;

import ej_integrador_p2.models.*;

public class FacturaImp implements Crud<Factura> {
  private static List<Factura> facturas = new ArrayList<>();

  @Override
  public void delete(String dni) {
    Optional<Factura> factura = this.findById(dni);
    if(factura.isEmpty()) System.out.println("No se encontro el cliente");
    else facturas.remove(factura.get());
  }

  @Override
  public List<Factura> findAll() {
    return facturas;
  }

  @Override
  public Optional<Factura> findById(String dni) {
    Integer index = Integer.valueOf(dni);
    try{
      return Optional.of(facturas.get(index));
    } catch (Exception e){
      return Optional.empty();
    }
  }

  @Override
  public void save(Factura t) {
    Optional<Cliente> cliente = ClientImp.find(t.getCliente().getDni());
    if(cliente.isEmpty()) ClientImp.create(t.getCliente());
    facturas.add(t);
  }

  @Override
  public void update(String dni) {
    // TODO Auto-generated method stub
    
  }
  
}
