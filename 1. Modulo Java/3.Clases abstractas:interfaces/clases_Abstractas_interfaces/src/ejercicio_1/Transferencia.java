package ejercicio_1;

public interface Transferencia extends Transaccion {
    void realizarTransferencia(Double monto, String cuentaDestino);
}
