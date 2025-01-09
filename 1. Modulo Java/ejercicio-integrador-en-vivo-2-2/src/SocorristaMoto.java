public class SocorristaMoto implements Socorrista {
    @Override
    public void socorrer(Vehiculo vehiculo) {
        System.out.println("Socorriendo moto" + vehiculo.getPatente());

    }
}