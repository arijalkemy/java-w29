package ejercicio1;
public class Basic extends Usuario implements Transaccion {
  public Basic(String nombres, double saldo) {
    super(nombres, saldo);
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

  public boolean servicios(Double value){
    System.out.println("Pago de servicios por " + value + " de la cuenta de " + super.getNombres());
    try{
      super.setSaldo(super.getSaldo() - value);
      return this.transaccionOk();
    } catch(Exception e){
      return this.transaccionNoOk();
    }
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
}
