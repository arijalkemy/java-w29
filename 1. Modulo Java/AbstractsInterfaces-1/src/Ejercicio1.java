public class Ejercicio1 {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        Basic basico = new Basic();
        Cobrador cobrador = new Cobrador();

        // Crear transacciones
        Deposito deposito = new Deposito();
        Transferencia transferencia = new Transferencia();
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        PagoServicio pagoServicios = new PagoServicio();

        // Ejecutivos hacen depósitos y transferencias
        ejecutivo.realizarDeposito(deposito);
        ejecutivo.realizarTransferencia(transferencia);

        // Clientes básicos hacen consultas de saldo, pagos de servicios y retiros
        basico.realizarConsultaSaldo(consultaSaldo);
        basico.realizarPagoServicios(pagoServicios);
        basico.realizarRetiroEfectivo(retiroEfectivo);

        // Cobradores hacen consultas de saldo y retiros
        cobrador.realizarConsultaSaldo(consultaSaldo);
        cobrador.realizarRetiroEfectivo(retiroEfectivo);
    }
}
