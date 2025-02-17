package com.example.demo.abstractClass.ej_1;

    public class Ejecutivo {
        private Deposito deposito = new Deposito();
        private Transferencia transferencia = new Transferencia();

        public void realizarDeposito() {
            deposito.transaccionOk();
        }

        public void realizarTransferencia() {
            transferencia.transaccionOk();
        }
    }
