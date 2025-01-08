package ejercicio1;
public class Cobradores extends Usuario implements Transaccion {
  public Cobradores(String nombres, double saldo) {
    super(nombres, saldo);
  }

  public boolean retiro(Double value){
    System.out.println("Retiro de " + value + " de la cuenta de " + super.getNombres());
    try{
      super.setSaldo(super.getSaldo() - value);
      return this.transaccionOk();
    } catch(Exception e){
      return this.transaccionNoOk();
    }
  }

  public boolean consulta(){
    System.out.println("Consulta de saldo de " + super.getNombres());
    try{
      System.out.println("Saldo: " + super.getSaldo());
      return this.transaccionOk();
    } catch(Exception e){
      return this.transaccionNoOk();
    }
  }
}
