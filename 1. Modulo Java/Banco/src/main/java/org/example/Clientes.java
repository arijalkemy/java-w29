package org.example;

public class Clientes {
    public static class Ejecutivo {
        public void realizarDeposito(Deposito deposito) {
            deposito.transaccionOk();
        }

        public void realizarTransferencia(Transferencia transferencia) {
            transferencia.transaccionOk();
        }
    }

    public static class Basic {
        public void consultarSaldo(ConsultaSaldo consulta) {
            consulta.transaccionOk();
        }

        public void pagarServicios(PagoServicios pago) {
            pago.transaccionOk();
        }

        public void retirarEfectivo(RetiroEfectivo retiro) {
            retiro.transaccionOk();
        }
    }

    public static class Cobrador {
        public void retirarEfectivo(RetiroEfectivo retiro) {
            retiro.transaccionOk();
        }

        public void consultarSaldo(ConsultaSaldo consulta) {
            consulta.transaccionOk();
        }
    }
}
