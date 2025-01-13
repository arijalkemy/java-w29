public class Participant {
    public String name;
    public String surname;
    public int age;
    public int dni;
    public int phone;
    public int emergencyPhone;
    public String bloodType;

    public Participant(String name, String surname, int age, int dni, int phone, int emergencyPhone, String bloodType) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dni = dni;
        this.phone = phone;
        this.emergencyPhone = emergencyPhone;
        this.bloodType = bloodType;
    }
}
