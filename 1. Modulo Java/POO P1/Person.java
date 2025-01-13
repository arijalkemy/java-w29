public class Person {
    private int name;
    private int age;
    private String dni;
    private double weight;
    private double height;


    public Person(){
    }

    public Person(int name, int age, String dni){
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(int name, int age, String dni, double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }


    public int calcularIMC(){
        int result = 0;
        double imc = this.weight / (this.height * this.height);
        if (imc < 20) result = -1;
        if (imc >= 20 && imc <= 25) result = 0;
        if (imc > 25) result = 1;
        return result;
    }

    public String calcularIMCString(){
        int result = this.calcularIMC();
        if (result == -1) return "Bajo peso";
        if (result == 0) return "Peso saludable";
        if (result == 1) return "Sobrepeso";
        return "Desconocido";
    }

    public boolean esMayorDeEdad(){
        return this.age >= 18;
    }

    public String toString(){
        return "Nombre: " + this.name + 
               "\nEdad: " + this.age +
               "\nDNI: " + this.dni +
               "\nPeso: " + this.weight + 
               "\nAltura: " + this.height + 
               "\nIMC: " + this.calcularIMCString() + 
               "\nEs mayor de edad: " + this.esMayorDeEdad();
    }
}
