public class SocorristaAuto implements Socorrista<Auto>{
    public void socorrer(Auto unAuto) {
        System.out.println("Socorriendo auto " + unAuto.getPatente());
    }
}