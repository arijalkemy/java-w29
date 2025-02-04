package ejercicio_1;

public class Ejecutivo implements Deposito, Transferencia{

    @Override
    public void transaccionOk(){
        System.out.println("Transacción exitosa");
    }

    @Override
    public void transaccionNoOk(){
        System.out.println("Transacción fallida");
    }

    @Override
    public void realizarDeposito(Double monto){
        System.out.println("Realizando deposito...");
        transaccionOk();
    }

    @Override
    public void realizarTransferencia(Double monto, String cuentaDestino){
        System.out.println("Realizando transferencia a "+  cuentaDestino);
        transaccionOk();
    }
}