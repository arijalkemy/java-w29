package ejercicio1.transacciones;

public class RetiroEfectivo implements Transaccion {
    @Override
    public void ok() {
        System.out.println("Realizando retiro efectivo: ok");
    }

    @Override
    public void noOk() {
        System.out.println("Realizando retiro efectivo: no Ok");
    }
}
