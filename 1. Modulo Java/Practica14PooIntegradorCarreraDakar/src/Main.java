public class Main {
    public static void main(String[] args) {
        System.out.println("------ INICIANDO PROGRAMA ------\n");
        Carrera carrera = new Carrera(1500.0, 10000.0, "Carrera DAKAR", 6);
        carrera.darDeAltaAuto(250.0, 8.0, 2.0, "ABC123");
        carrera.darDeAltaAuto(190.0, 6.0, 2.0, "DEF456");
        carrera.darDeAltaMoto(150.0, 4.0, 2.0, "GHI789");
        carrera.darDeAltaMoto(120.0, 3.0, 1.0, "DGQ52H");
        System.out.println("----ATENCIÓN DE EMERGENCIA A ALGÚN VEHICULO----");
        carrera.socorrerAuto("ABC123");
        carrera.socorrerMoto("GHI789");
        System.out.println("----GANADOR DE LA COMPENTENCIA----");
        System.out.println("\nEl ganador de la carrera es: " + carrera.ganador());
    }
}