package integrador_p1;

import java.util.*;

public class Reserva {
  private List<Producto> productos;

  public String toString(){
    return "\n\t-----------------------------------\n" + "Productos: " + productos;
  }

  public Reserva() {
    this.productos = new ArrayList<>();
  }

  public Reserva(List<Producto> productos) {
    this.productos = productos;
  }

  public List<Producto> getProductos() {
    return productos;
  }

  public void setProductos(List<Producto> productos) {
    this.productos = productos;
  }

  public Double getTotal() {
    return productos.stream().mapToDouble(producto -> producto.getPrecio()).sum();
  }

  public Boolean haveAllProductTypes() {
    Set<Producto.Tipo> tipos = EnumSet.noneOf(Producto.Tipo.class);
    productos.stream().forEach(producto -> tipos.add(producto.getTipoProducto()));
    return tipos.containsAll(EnumSet.allOf(Producto.Tipo.class));
  }

  public Integer numReservaProductType() {
    return productos.stream().filter(producto -> producto.getTipoProducto() == Producto.Tipo.RESERVA).mapToInt(producto -> 1).sum();
  }

  public Integer numBoletosProductType() {
    return productos.stream().filter(producto -> producto.getTipoProducto() == Producto.Tipo.BOLETOS).mapToInt(producto -> 1).sum();
  }

  public Boolean hasProductType(Producto.Tipo tipo) {
    return productos.stream().anyMatch(producto -> producto.getTipoProducto() == tipo);
  }
}
