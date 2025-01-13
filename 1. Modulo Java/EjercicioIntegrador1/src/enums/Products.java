package enums;

public enum Products {
    HOTEL("Hotel"),
    TICKET("Ticket"),
    FOOD("Food"),
    TRANSPORT("Transport");

    private final String type;

    Products(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
