public class Garment {
    private final String brand;
    private final String size;

    // Constructor
    public Garment(String brand, String size) {
        this.brand = brand;
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return brand + " brand and " + size + " size garment";
    }
}
