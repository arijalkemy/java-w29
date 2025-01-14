public class SocorristaMoto implements Socorrista<Moto> {
    @Override
    public void socorrer(Moto moto) {
        System.out.println("Socorriendo moto con patente: " + moto.getPatente());
    }
}
