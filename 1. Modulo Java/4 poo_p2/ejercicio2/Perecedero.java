public class Perecedero extends Producto {
  private int diasPorCaducar;

  public Perecedero(String nombre, double precio, int diasPorCaducar) {
    super(nombre, precio);
    this.diasPorCaducar = diasPorCaducar;
  }

  @Override
  public String toString() {
    return super.toString() + ", Días por caducar: " + diasPorCaducar;
  }

  @Override
  public double calcular(int cantidad) {
    double precio = super.calcular(cantidad);
    if(this.diasPorCaducar <= 1) precio /= 4;
    else if(this.diasPorCaducar <= 2) precio /= 3;
    else if(this.diasPorCaducar <= 3) precio /= 2;
    return precio;
  }

  public int getDiasPorCaducar() {
    return this.diasPorCaducar;
  }
  public void setDiasPorCaducar(int diasPorCaducar) {
    this.diasPorCaducar = diasPorCaducar;
  }
}
