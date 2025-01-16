public class Client {
    private Integer dni;
    private String name;

    // Constructor
    public Client(Integer dni, String name) {
        this.dni = dni;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client - [dni=" + dni + ", name=" + name + "]";
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }
}
