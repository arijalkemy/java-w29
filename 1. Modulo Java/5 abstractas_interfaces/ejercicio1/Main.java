package ejercicio1;
public class Main {
  public static void main(String[] args) {
    Cobradores cobrador = new Cobradores("Juan", 1000);
    Ejecutivos ejecutivo = new Ejecutivos("Pedro", 2000);
    Usuario usuario = new Usuario("Maria", 3000);

    cobrador.retiro(500.0);
    cobrador.consulta();
    ejecutivo.deposito(1000.0);
    ejecutivo.transferencia(500.0, usuario);
  }
}
