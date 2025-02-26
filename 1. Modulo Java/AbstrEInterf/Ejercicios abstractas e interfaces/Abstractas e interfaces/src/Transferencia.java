public class Transferencia implements Transaccionable {

    public Transferencia() {

    }

    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia no realizada, fallo en la transacción.");
    }

    @Override
    public void realizarTransaccion(Cliente client) {

        System.out.println("Realizando transferencia ...");

        String type = client.getClass().getName().replaceAll("com.interfaces.", "");

        if (type.equals("Ejecutivo")) {
            transaccionOk();
        } else {
            transaccionNoOk();
        }
    }

}