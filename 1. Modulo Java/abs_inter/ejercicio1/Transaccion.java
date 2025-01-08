package ejercicio1;
public interface Transaccion {
  default boolean transaccionOk(){
    System.out.println("Transaccion exitosa");
    return true;
  }
  default boolean transaccionNoOk(){
    System.out.println("Transaccion fallida");
    return false;
  }
}