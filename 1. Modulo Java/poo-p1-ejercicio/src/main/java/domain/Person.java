package domain;

public class Person {
    private String dni;
    private String name;
    private int age;
    private float weightInKg;
    private float sizeInMts;

    public Person() {
    }

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(String name, int age, String dni, float weightInKg, float sizeInMts) {
        this.dni = dni;
        this.name = name;
        this.age = age;
        this.weightInKg = weightInKg;
        this.sizeInMts = sizeInMts;
    }

    public int calcIMC() {
        double imc = this.weightInKg / (Math.pow(sizeInMts, 2));
        if (imc < 20.0) return -1;
        else if (imc >= 20.0 && imc <= 25.0) return 0;
        else return 1;
    }

    public boolean isAdult() {
        return this.age >= 18;
    }

    @Override
    public String toString() {
        return String.format(
                "Nombre: %s \nEdad: %d \nDNI: %s \nPeso: %.2f kg \nAltura: %.2f mts",
                this.name,
                this.age,
                this.dni,
                this.weightInKg,
                this.sizeInMts
        );
    }
}
