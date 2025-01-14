package ej_integrador_p2.models;

import java.util.*;
import lombok.*;

@Getter
@ToString
public class Factura {
  private Cliente cliente;
  private List<Item> items;
  private Double total;

  public Factura(Cliente cliente, List<Item> items) {
    this.cliente = cliente;
    this.items = items;
    this.total = items.stream().mapToDouble(item -> item.getUnitaryPrice() * item.getQuantity()).sum();
  }
}