package com.bootcamp.model;

import java.util.List;

public class Sport {

    private String name;
    private String level;
    private List<Person> persons;

    public Sport() {
    }

    public Sport(String name, String level, List<Person> persons) {
        this.name = name;
        this.level = level;
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
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
        return "Sport{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", persons=" + persons +
                '}';
    }
}
