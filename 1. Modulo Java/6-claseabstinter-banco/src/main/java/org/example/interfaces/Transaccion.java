package org.example.interfaces;

// Un banco tiene diferentes tipos de transacciones que puede llevar a cabo, entre ellas se encuentran:
// Depósito, Transferencia, Retiro de Efectivo, Consulta de Saldo, Pago de Servicios. Todas las transacciones
// tienen dos métodos en común, que son transaccionOk() y transaccionNoOk().

public interface Transaccion {
    public abstract void transaccionOk(String tipoTransaccion);
    public abstract void transaccionNoOk(String tipoTransaccion);
}
