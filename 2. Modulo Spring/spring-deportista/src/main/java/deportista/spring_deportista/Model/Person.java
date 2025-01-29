package deportista.spring_deportista.Model;

public class Person {
    private String name;
    private String lastname;
    private Integer age;
    private Integer fkSportId;

    public Person(String name, String lastname, Integer age, Integer fkSportId) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.fkSportId = fkSportId;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getFkSportId() {
        return fkSportId;
    }

    public void setFkSportId(Integer fkSportId) {
        this.fkSportId = fkSportId;
    }
}
