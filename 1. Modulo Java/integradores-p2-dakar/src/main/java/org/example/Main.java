package org.example;

public class Main {
    public static void main(String[] args) {
        Auto auto1 = new Auto(300.0, 100.0, 75.0, "AJK 197");
        Moto moto1 = new Moto(100.0, 142.0, 72.0, "AAK 191");

        Carrera granPrixDeEdu = new Carrera(174.5, 1000.0, "Gran Prix de Edu", 3);

        System.out.println("----------------------------------------------------------------------------------");

        granPrixDeEdu.darDeAltaAuto(300.0, 100.0, 75.0, "AJK 197");
        granPrixDeEdu.eliminarVehiculo(auto1);
        granPrixDeEdu.darDeAltaAuto(300.0, 100.0, 75.0, "AJK 197");
        granPrixDeEdu.darDeAltaAuto(270.0, 84.0, 90.0, "PPP 223");
        granPrixDeEdu.darDeAltaAuto(270.0, 84.0, 90.0, "PPP 223");

        System.out.println("----------------------------------------------------------------------------------");

        granPrixDeEdu.darDeAltaMoto(150.0, 59.7, 34.2, "MOT 069");
        granPrixDeEdu.darDeAltaMoto(350.0, 7.3, 150.0, "ONE 234");
        granPrixDeEdu.eliminarVehiculoConPatente("MOT 069");
        granPrixDeEdu.darDeAltaMoto(350.0, 7.3, 150.0, "ONE 234");

        System.out.println("----------------------------------------------------------------------------------");

        SocorristaAuto socorritaAuto = new SocorristaAuto();
        SocorristaMoto socorritaMoto = new SocorristaMoto();
        socorritaAuto.socorrer(auto1);
        socorritaMoto.socorrer(moto1);
    }
}