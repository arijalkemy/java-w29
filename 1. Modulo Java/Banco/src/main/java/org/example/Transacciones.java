package org.example;

public class Transacciones {
    public static class Deposito implements Transaccion {
        @Override
        public void transaccionOk() {
            System.out.println("Realizándose depósito...");
        }

        @Override
        public void transaccionNoOk() {
            System.out.println("Depósito no realizado.");
        }
    }

    public static class Transferencia implements Transaccion {
        @Override
        public void transaccionOk() {
            System.out.println("Realizándose transferencia...");
        }

        @Override
        public void transaccionNoOk() {
            System.out.println("Transferencia no realizada.");
        }
    }

    public static class RetiroEfectivo implements Transaccion {
        @Override
        public void transaccionOk() {
            System.out.println("Realizándose retiro de efectivo...");
        }

        @Override
        public void transaccionNoOk() {
            System.out.println("Retiro no realizado.");
        }
    }

    public static class ConsultaSaldo implements Transaccion {
        @Override
        public void transaccionOk() {
            System.out.println("Consulta de saldo efectuada.");
        }

        @Override
        public void transaccionNoOk() {
            System.out.println("Consulta de saldo fallida.");
        }
    }

    public static class PagoServicios implements Transaccion {
        @Override
        public void transaccionOk() {
            System.out.println("Realizando pago de servicios...");
        }

        @Override
        public void transaccionNoOk() {
            System.out.println("Pago de servicios no realizado.");
        }
    }
}
