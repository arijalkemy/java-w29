public class SocorristaAuto implements Socorrista<Autos> {
    @Override
    public void socorrer(Autos auto) {
        System.out.println("Socorriendo auto:\n " + auto);
    }
}
