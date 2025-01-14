public class Ejecutivo extends Cliente{
    public Ejecutivo(String nombre) {
        super(nombre);
    }

    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        if (transaccion instanceof Deposito || transaccion instanceof Transferencia) {
            transaccion.transaccionOk();
        } else{
            transaccion.transaccionNoOk();
        }
    }
}
