import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Race {
    private final Integer distance;
    private final Double price;
    private final String name;
    private final Integer allowedVehicles;
    private List<Vehicle> vehicles;
    private final CarLifeGuard carLifeGuard = new CarLifeGuard();
    private final MotorcycleLifeGuard motorcycleLifeGuard = new MotorcycleLifeGuard();

    public Race(Integer distance, Double price, String name, Integer allowedVehicles, List<Vehicle> vehicles) {
        this.distance = distance;
        this.price = price;
        this.name = name;
        this.allowedVehicles = allowedVehicles;
        this.vehicles = vehicles;
    }

    public Race(Integer distance, Double price, String name, Integer allowedVehicles) {
        this.distance = distance;
        this.price = price;
        this.name = name;
        this.allowedVehicles = allowedVehicles;
        this.vehicles = new ArrayList<>();
    }

    public void addACar(Integer speed, Integer acceleration, Integer turningAngle, String licensePlate) {
        if(allowedVehicles > vehicles.size())
            vehicles.add(new Car(speed, acceleration, turningAngle, licensePlate));
    }

    public void addAMotorcycle(Integer speed, Integer acceleration, Integer turningAngle, String licensePlate) {
        if(allowedVehicles > vehicles.size())
            vehicles.add(new Motorcycle(speed, acceleration, turningAngle, licensePlate));
    }

    public void deleteAVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public void deleteAVehicleByLicensePlate(String licensePlate) {
        vehicles.removeIf(v -> v.getLicensePlate().equals(licensePlate));
    }

    public Optional<Vehicle> getRaceWinner() {
        return vehicles.stream().max(Comparator.comparingInt(Race::getWinningFormula));
    }

    private static Integer getWinningFormula(Vehicle vehicle) {
        return vehicle.getSpeed() * (vehicle.getAcceleration() / 2) /
            (vehicle.getTurningAngle() * (vehicle.getWeight() - vehicle.getWheels() * 100));
    }

    public void helpACar(String licensePlate) {
        getVehicleByLicensePlate(licensePlate)
                .ifPresent(v -> {
                    if (v instanceof Car) {
                        carLifeGuard.help((Car) v);
                    } else {
                        System.out.println("Could not find a car to help");
                    }
                });
    }

    public void helpAMotorcycle(String licensePlate) {
        getVehicleByLicensePlate(licensePlate)
                .ifPresent(v -> {
                    if (v instanceof Motorcycle) {
                        motorcycleLifeGuard.help((Motorcycle) v);
                    } else {
                        System.out.println("Could not find a motorcycle to help");
                    }
                });
    }

    public Optional<Vehicle> getVehicleByLicensePlate(String licensePlate) {
        return vehicles.stream()
                .filter(v -> v.getLicensePlate().equals(licensePlate))
                .findFirst();
    }

    public void printVehicles() {
        System.out.println("Rally Dakar vehicles: " + vehicles.toString());
    }

    public Integer getDistance() {
        return distance;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Integer getAllowedVehicles() {
        return allowedVehicles;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
