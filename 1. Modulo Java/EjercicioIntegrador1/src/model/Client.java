package model;

public class Client {
    private static Integer lastId = 0;
    private Integer id;
    private String name;

    public Client(String name) {
        Client.lastId += 1;
        this.id = Client.lastId;
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
