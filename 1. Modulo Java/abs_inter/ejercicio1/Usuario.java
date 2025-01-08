package ejercicio1;
public class Usuario {
  private String nombres;
  private double saldo;

  public Usuario(String nombres, double saldo) {
    this.nombres = nombres;
    this.saldo = saldo;
  }

  public String getNombres() {
    return this.nombres;
  }
  public double getSaldo() {
    return this.saldo;
  }
  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }
}
