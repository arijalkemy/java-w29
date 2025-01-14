public class Cobrador extends Cliente{
    public Cobrador(String nombre) {
        super(nombre);
    }

    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        if (transaccion instanceof RetiroEfectivo || transaccion instanceof  ConsultaSaldo){
            transaccion.transaccionOk();
        }else{
            transaccion.transaccionNoOk();
        }
    }
}
