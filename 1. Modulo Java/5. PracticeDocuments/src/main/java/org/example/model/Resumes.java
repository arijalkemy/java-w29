package org.example.model;

import org.example.interfaces.IPrintable;

import java.util.List;

public class Resumes implements IPrintable {

    /**
     * Attributes
     */
    private String name;
    private String lastname;
    private int age;
    private String email;
    private List<String> skills;

    /**
     * Constructor
     */
    public Resumes(String name, String lastname, int age, String email, List<String> skills) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Curriculums -- \n" +
                "Nombre: " + name + '\n' +
                "Apellido:" + lastname + '\n' +
                "Edad: " + age + '\n' +
                "Correo: " + email + '\n' +
                "Habilidades: " + skills + '\n';
    }

    @Override
    public void print(Object document) {
        System.out.println(((Resumes) document).toString());
    }
}
