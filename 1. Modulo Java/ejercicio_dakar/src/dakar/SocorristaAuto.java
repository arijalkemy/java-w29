package dakar;

public class SocorristaAuto implements Socorrista<Auto> {
    @Override
    public void socorrer(Auto auto) {
        System.out.println("Socorriendo Auto.. " + auto.getPatente());
    }
}
