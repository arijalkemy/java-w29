public class Vehicle {
    private Integer speed;
    private Integer acceleration;
    private Integer turningAngle;
    private String licensePlate;
    private Integer weight;
    private Integer wheels;

    public Vehicle(Integer speed, Integer acceleration, Integer turningAngle, String licensePlate, Integer weight, Integer wheels) {
        this.speed = speed;
        this.acceleration = acceleration;
        this.turningAngle = turningAngle;
        this.licensePlate = licensePlate;
        this.weight = weight;
        this.wheels = wheels;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Integer getAcceleration() {
        return acceleration;
    }

    public Integer getTurningAngle() {
        return turningAngle;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getWheels() {
        return wheels;
    }

    @Override
    public String toString() {
        return "License plate: " + licensePlate;
    }
}
