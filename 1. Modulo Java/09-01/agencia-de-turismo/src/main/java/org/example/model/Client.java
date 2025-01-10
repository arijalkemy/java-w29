package org.example.model;

public class Client {
    private static Long lastId = 0L;

    private final Long id;
    private final String name;

    public Client(String name) {
        id = ++lastId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
