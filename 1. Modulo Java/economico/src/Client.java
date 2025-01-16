public class Client {
    private String dni;
    private String firstName;
    private String lastName;

    // Constructor
    public Client(String dni, String firstName, String lastName) {
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Client - DNI: " + dni + ", First Name: " + firstName + ", Last Name: " + lastName + ".";
    }

    // Getters and setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
