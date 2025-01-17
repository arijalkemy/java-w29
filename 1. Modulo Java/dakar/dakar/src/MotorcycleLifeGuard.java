public class MotorcycleLifeGuard implements LifeGuard<Motorcycle> {
    @Override
    public void help(Motorcycle vehicle) {
        System.out.println("Helping motorcycle " + vehicle.getLicensePlate());
    }
}
