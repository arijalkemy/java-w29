import java.util.List;

public class Invoice {
    private final String id;
    private final Client client;
    private final List<Item> items;

    // Constructor
    public Invoice(String id, Client client, List<Item> items) {
        this.id = id;
        this.client = client;
        this.items = items;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public List<Item> getItems() {
        return items;
    }
}
