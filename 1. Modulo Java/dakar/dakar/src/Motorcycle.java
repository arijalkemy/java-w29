public class Motorcycle extends Vehicle {
    public Motorcycle(Integer speed, Integer acceleration, Integer turningAngle, String licensePlate) {
        super(speed, acceleration, turningAngle, licensePlate, 300, 2);
    }

    @Override
    public String toString() {
        return "Motorcycle - " + super.toString();
    }
}
