public class Persona {

    private String name;
    private int age;
    private String dni;
    private double weight;
    private double height;


    public Persona() {
    }

    public Persona(String name, int age, String dni, double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public Persona (String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public int calcularIMC() {
        double result = this.weight / (this.height * this.height);

        if (result < 20) {
            return -1;
        } else if (result >= 20 && result <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad() {
        return this.age >= 18;
    }

    @Override
    public String toString() {
        return "Datos de la persona" +
                "\n- Nombre: " + name +
                "\n- Edad: " + age +
                "\n- DNI: " + dni +
                "\n- Peso: " + weight +
                "\n- Altura: " + height;
    }
}
