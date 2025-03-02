package Cliente;

import Transaccion.Deposito;
import Transaccion.Transferencia;

public class Ejecutivo {
    public void realizarDeposito() {
        new Deposito().transaccionOk();
    }

    public void realizarTransferencia() {
        new Transferencia().transaccionOk();
    }
}
