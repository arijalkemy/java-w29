public class Main {
    public static void main(String[] args) {
        Race dakar = new Race(235, 1000000.00, "Rally Dakar", 3);

        Car redBull = new Car(100, 80, 70, "123");
        Car mercedes = new Car(120, 50, 80, "234");
        Motorcycle yamaha = new Motorcycle(70, 120, 40, "345");
        Motorcycle kawasaki = new Motorcycle(80, 100, 50, "456");

        dakar.addACar(100, 80, 70, "123");
        dakar.addACar(120, 50, 80, "234");
        dakar.addAMotorcycle(70, 120, 40, "345");
        dakar.addAMotorcycle(80, 100, 50, "456");

        dakar.printVehicles();

        dakar.deleteAVehicleByLicensePlate("345");
        dakar.addAMotorcycle(80, 100, 50, "456");

        dakar.printVehicles();

        System.out.println("The winner is... " + dakar.getRaceWinner().get());

        dakar.helpACar("123");
        dakar.helpACar("456");
        dakar.helpACar("567");
        dakar.helpAMotorcycle("456");
        dakar.helpAMotorcycle("234");
        dakar.helpAMotorcycle("567");
    }
}