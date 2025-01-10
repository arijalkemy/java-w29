public class Basico extends Cliente{
    public Basico(String nombre) {
        super(nombre);
    }

    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        if (transaccion instanceof ConsultaSaldo || transaccion instanceof  PagoServicios || transaccion instanceof RetiroEfectivo){
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}
