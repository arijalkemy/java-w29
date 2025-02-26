public class PagoServicios implements Transaccionable {

    public PagoServicios() {

    }

    @Override
    public void transaccionOk() {
        System.out.println("Pago de Servicio realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de Servicio no realizado, fallo en la transacción.");
    }

    @Override
    public void realizarTransaccion(Cliente client) {

        System.out.println("Realizando Pago de Servicio ...");

        String type = client.getClass().getName().replaceAll("com.interfaces.", "");

        if (type.equals("Basico")) {
            transaccionOk();
        } else {
            transaccionNoOk();
        }
    }

}