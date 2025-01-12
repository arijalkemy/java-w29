package ejercicio1.transacciones;

public class Deposito implements Transaccion {

    @Override
    public void ok() {
        System.out.println("Realizando deposito: Ok");
    }

    @Override
    public void noOk() {
        System.out.println("Realizando deposito: no Ok");
    }
}
