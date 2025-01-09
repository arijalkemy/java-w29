public class Cobrador extends Cliente {

    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        if (transaccion instanceof RetiroEfectivo || transaccion instanceof ConsultaSaldo) {
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}
