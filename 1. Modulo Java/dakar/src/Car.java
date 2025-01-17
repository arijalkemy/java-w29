public class Car extends Vehicle {
    public Car(Integer speed, Integer acceleration, Integer turningAngle, String licensePlate) {
        super(speed, acceleration, turningAngle, licensePlate, 1000, 4);


    }

    @Override
    public String toString() {
        return "Car - " + super.toString();
    }
}
