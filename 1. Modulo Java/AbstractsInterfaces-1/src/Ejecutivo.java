public class Ejecutivo {

    public void realizarDeposito(Deposito deposito) {
        deposito.transaccionOk();
    }

    public void realizarTransferencia(Transferencia transferencia) {
        transferencia.transaccionOk();
    }
}
