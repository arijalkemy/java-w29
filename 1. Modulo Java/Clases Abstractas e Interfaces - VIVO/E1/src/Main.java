import Cliente.*;

public class Main {
    public static void main(String[] args) {
        Basico clienteBasico = new Basico();
        Cobrador clienteCobrador = new Cobrador();
        Ejecutivo clienteEjecutivo = new Ejecutivo();

        // Transacciones de cliente basico
        clienteBasico.realizarConsultaSaldo();
        clienteBasico.realizarPagoServicio();
        clienteBasico.realizarRetiroEfectivo();

        // Transacciones de cliente cobrador
        clienteCobrador.realizarConsultaSaldo();
        clienteCobrador.realizarRetiroEfectivo();

        // Transacciones de cliente ejecutivo
        clienteEjecutivo.realizarDeposito();
        clienteEjecutivo.realizarTransferencia();
    }
}