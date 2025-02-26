/*
Un banco tiene diferentes tipos de transacciones que puede llevar a cabo, entre ellas se encuentran:
Depósito, Transferencia, Retiro de Efectivo, Consulta de Saldo, Pago de Servicios.
Todas las transacciones tienen dos métodos en común, que son transaccionOk() y transaccionNoOk().

Ejecutivos: Realizan Depósitos y Transferencias.
Basic: Realizan consultas de saldo, pagos de servicios y retiro de efectivo.
Cobradores: Realizan retiro de efectivo y consulta de saldos.
*/

public interface Transaccion {

    public String transaccionOk(String tipoTransaccion);

    public String transaccionNoOk(String tipoTransaccion);

}
