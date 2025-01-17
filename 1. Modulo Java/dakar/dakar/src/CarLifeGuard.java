public class CarLifeGuard implements LifeGuard<Car> {
    @Override
    public void help(Car vehicle) {
        System.out.println("Helping car " + vehicle.getLicensePlate());
    }
}
