public class SocorristaMoto implements Socorrista<Moto>{
    public void socorrer(Moto unaMoto) {
        System.out.println("Socorriendo moto " + unaMoto.getPatente());
    }
}