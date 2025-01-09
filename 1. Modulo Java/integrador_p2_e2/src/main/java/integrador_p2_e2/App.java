package integrador_p2_e2;

public class App {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(1500.0, 10000.0, "Carrera DAKAR", 3);
        carrera.darDeAltaAuto(150.0, 2.0, 2.0, "ABC123");
        carrera.darDeAltaAuto(150.0, 2.0, 2.0, "DEF456");
        carrera.darDeAltaMoto(150.0, 2.0, 2.0, "GHI789");
        carrera.socorrerAuto("ABC123");
    }
}