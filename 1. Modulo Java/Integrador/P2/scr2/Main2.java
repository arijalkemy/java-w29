public class Main2 {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(500, 10000, "Gran Premio", 10);

        carrera.darDeAltaAuto(150, 10, 30, "ABC123");
        carrera.darDeAltaAuto(160, 12, 25, "DEF456");
        carrera.darDeAltaMoto(140, 15, 20, "GHI789");
        carrera.darDeAltaMoto(130, 14, 22, "JKL012");

        carrera.mostrarVehiculos();

        Vehiculo ganador = carrera.determinarGanador();
        System.out.println("El ganador es: " + ganador.getPatente());

       // carrera.socorrerAuto("ABC123");
       // carrera.socorrerMoto("JKL012");

        carrera.socorrer("ABC123");
        carrera.socorrer("JKL012");

        System.out.println("Elimino vehiculo");
        carrera.eliminarVehiculoConPatente("DEF456");

        carrera.mostrarVehiculos();


    }
}