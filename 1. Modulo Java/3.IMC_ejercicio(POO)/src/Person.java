public class Person {
    private String name;
    private int age = 1;
    private String dni;
    private double weight;
    private double height;

    public Person() {

    }

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(String name, int age, String dni, double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.height = height;
        this.weight = weight;
    }


    public int calcularIMC(){
        double imc = this.weight / (Math.pow(this.height, 2)) - this.weight - this.height;

        if (imc < 20) return -1;
        else if (imc >= 20 && imc <= 25 ) return 0;
        else return 1;
    }

    public boolean esMayordeEdad(){
        return this.age > 18;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.name + ", Edad: " + this.age + ", DNI: " + this.dni + ", Peso: " + this.weight + ", Altura: " + this.height;
    }





}
