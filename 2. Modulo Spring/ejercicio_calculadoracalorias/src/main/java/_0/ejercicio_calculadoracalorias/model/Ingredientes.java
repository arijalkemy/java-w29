package _0.ejercicio_calculadoracalorias.model;

public class Ingredientes {
    private String name;
    private Integer calories;

    //constructor

    // Constructor por defecto
    public Ingredientes() {
    }

    public Ingredientes(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    //getter y setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    //to string


    @Override
    public String toString() {
        return "Ingredientes{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
}
