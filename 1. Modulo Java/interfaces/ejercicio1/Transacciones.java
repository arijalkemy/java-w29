package ejercicio1;

public interface Transacciones {
    String transaccionOk();
    String transaccionNoOk();
    // Métodos para las transacciones específicas
    String deposito();
    String transferencia();
    String retiro();
    String consultaSaldo();
    String pagoServicios();
}