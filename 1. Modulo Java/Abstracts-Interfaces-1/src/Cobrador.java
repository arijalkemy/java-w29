public class Cobrador {
    public void realizarConsultaSaldo(ConsultaSaldo consulta) {
        consulta.transaccionOk();
    }

    public void realizarRetiroEfectivo(RetiroEfectivo retiro) {
        retiro.transaccionOk();
    }
}
