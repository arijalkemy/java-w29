public class SocorristaMoto implements Socorrista<Motos> {
    @Override
    public void socorrer(Motos moto) {
        System.out.println("Socorriendo moto:\n " + moto);
    }
}
