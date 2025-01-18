package com.spring_p1.sports.model;

public class Sport {
    private int id;
    private String name;
    private String level;

    // Constructor
    public Sport(int id, String name, String level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Sport [id=" + id + ", name=" + name + ", level=" + level + "]";
    }
}
