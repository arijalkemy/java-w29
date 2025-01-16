public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private int peso;
    private int altura;

    // Constructors
    public Persona() {
        // ...
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, int peso, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    // Methods
    public void printNameAgeAndDNI() {
        System.out.println("Name: " + this.nombre + ". Age: " + this.edad + ". DNI: " + this.dni + ".\n");
    }

    public int calculateIMC() {
        double imc = this.peso / (Math.pow(this.altura, 2));
        if (imc < 20) {
            System.out.println("IMC less than 20: Low weight.");
            return -1;
        } else if (imc < 26) {
            System.out.println("IMC between 20 and 25: Healthy weight.");
            return 0;
        } else {
            System.out.println("IMC greater than 25: Overweight.");
            return 1;
        }
    }

    public boolean isOfLegalAge() {
        boolean isOverEighteen = this.edad >= 18;
        System.out.println("Is " + this.nombre + " over 18 years old?: " + isOverEighteen);
        return isOverEighteen;
    }

    public String toString() {
        return "Name: " +
                this.nombre +
                ". Age: " +
                this.edad +
                ". DNI: " +
                this.dni +
                ". Weight: " +
                this.peso +
                ". Height: " +
                this.altura +
                ".";
    }

    public void printAllAttributes() {
        System.out.println(this.toString());
    }
}