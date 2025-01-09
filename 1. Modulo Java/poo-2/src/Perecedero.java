public class Perecedero extends Producto {
  private int diasPorCaducar;

  public Perecedero(String nombre, double precio, int diasPorCaducar) {
    super(nombre, precio);
    this.diasPorCaducar = diasPorCaducar;
  }

  @Override
  public double calcular(int cantidadDeProductos) {
    double precioConDescuento = this.getPrecio();
    if (diasPorCaducar == 1) precioConDescuento = precioConDescuento / 4;
    if (diasPorCaducar == 2) precioConDescuento = precioConDescuento / 3;
    if (diasPorCaducar == 3) precioConDescuento = precioConDescuento / 2;
    return cantidadDeProductos * precioConDescuento;
  }
}
