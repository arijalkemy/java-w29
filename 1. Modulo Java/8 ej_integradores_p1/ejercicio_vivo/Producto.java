package integrador_p1;

public class Producto {
  public static enum Tipo{
    RESERVA("Reserva de Hotel"),
    COMIDA("Comida"),
    BOLETOS("Boletos de viajes"),
    TRANSPORTE("Transporte");
    
    private String descripcion;

    Tipo(String descripcion){
      this.descripcion = descripcion;
    }
    public String getDescripcion(){
      return descripcion;
    }
  }

  private Double precio;
  private Tipo tipoProducto;

  public String toString(){
    return "Precio: " + precio + " Tipo: " + tipoProducto;
  }
  
  public Producto(Double precio, Tipo tipoProducto){
    this.precio = precio;
    this.tipoProducto = tipoProducto;
  }
  public Double getPrecio(){
    return precio;
  }
  public Tipo getTipoProducto(){
    return tipoProducto;
  }
}
