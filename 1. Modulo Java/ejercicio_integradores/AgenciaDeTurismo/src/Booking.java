import java.util.Objects;

public class Booking {

    public enum Type {
        TICKET,
        TRANSPORT,
        FOOD,
        HOTEL
    }

    private Type  type;
    private Double cost;

    public Booking(Type type, Double cost) {
        this.type = type;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || this.getClass() != object.getClass())
            return false;
        Booking booking = (Booking) object;
        return this.type == booking.type && Objects.equals(this.cost, booking.cost);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "type=" + type +
                ", cost=" + cost +
                '}';
    }
}
