import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String patenteAuto = "AAA";
        String patenteAuto2 = "CCC";
        String patenteMoto = "BBB";

        Vehiculo auto = new Auto(100f, 100f, 10f, "ABC");

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(auto);

        Carrera carrera = new Carrera(
                100f,
                1000f,
                "La Mejor Carrera?",
                4,
                vehiculos,
                new SocorristaAuto(),
                new SocorristaMoto()
        );

        carrera.darDeAltaAuto(
                100f,
                100f,
                10f,
                patenteAuto
        );

        carrera.darDeAltaAuto(
                100f,
                100f,
                10f,
                patenteAuto2
        );

        carrera.darDeAltaMoto(
                90f,
                110f,
                30f,
                patenteMoto
        );



        // Baja auto por referencia
        System.out.println("Autos iniciales");
        carrera.getVehiculos().forEach(System.out::println);

        System.out.println("Luego de eliminar");
        carrera.eliminarVehiculo(auto);
        carrera.getVehiculos().forEach(System.out::println);

        // Baja por patente
        System.out.println("Antes de borrar por patente");
        carrera.getVehiculos().forEach(System.out::println);

        System.out.println("Luego de borrar por patente");
        carrera.eliminarVehiculoConPatente(patenteMoto);
        carrera.getVehiculos().forEach(System.out::println);

        // Ganador de la carrera
        System.out.println("Ganador: " + carrera.ganador());

    }
}