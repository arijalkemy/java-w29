public class Basic {
    public void realizarConsultaSaldo(ConsultaSaldo consulta) {
        consulta.transaccionOk();
    }

    public void realizarPagoServicios(PagoServicio pago) {
        pago.transaccionOk();
    }

    public void realizarRetiroEfectivo(RetiroEfectivo retiro) {
        retiro.transaccionOk();
    }
}
