package ejercicio1;
public class Ejecutivos extends Usuario implements Transaccion {
  public Ejecutivos(String nombres, double saldo) {
    super(nombres, saldo);
  }

  public boolean deposito(Double value){
    System.out.println("Deposito de " + value + " a la cuenta de " + super.getNombres());
    try{
      super.setSaldo(super.getSaldo() + value);
      return this.transaccionOk();
    } catch(Exception e){
      return this.transaccionNoOk();
    }
  }

  public boolean transferencia(Double value, Usuario user){
    System.out.println("Transferencia de " + value + " a la cuenta de " + user.getNombres());
    try {
      super.setSaldo(super.getSaldo() - value);
      user.setSaldo(user.getSaldo() + value);
      return this.transaccionOk();
    } catch (Exception e) {
      return this.transaccionNoOk();
    }
  }
}
