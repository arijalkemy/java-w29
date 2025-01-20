package Ex1.Clases;


import Ex1.Transactions.ConsultaSaldo;
import Ex1.Transactions.PagoServicio;
import Ex1.Transactions.RetiroEfec;

public class Basic implements ConsultaSaldo, PagoServicio, RetiroEfec {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando Saldo....");
 }

    @Override
    public void pagarServicio(String tipoServicio) {
        System.out.println("Pagando servicio: " + tipoServicio);

    }

    @Override
    public void retirarEfectivo(Double monto) {
        System.out.println("Retirando monto: " + monto);
    }

    @Override
    public void transaccionOk() {

        System.out.println(" Realizada correctamente!");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println(" No se pudo finalizar la operacion");
    }
}
