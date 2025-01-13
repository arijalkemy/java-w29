package org.example.model;

public class Client {
    /**
     * Attributes
     */
    private String name;
    private String dni;
    private String email;

    /**
     * Constructor
     * @param name Client name
     * @param dni Client dni
     * @param email Client email
     */
    public Client(String name, String dni, String email) {
        this.name = name;
        this.dni = dni;
        this.email = email;
    }

    /**
     * Getters and setters
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client ==== " +
                "Name: " + name + '\n' +
                "Dni: " + dni + '\n' +
                "Email: " + email + '\n';
    }
}
