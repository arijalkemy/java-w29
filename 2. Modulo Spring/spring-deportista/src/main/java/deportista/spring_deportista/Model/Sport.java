package deportista.spring_deportista.Model;

public class Sport {
    private Integer sportId;
    private String name;
    private Integer level;

    public Sport(Integer sportId, String name, Integer level) {
        this.sportId = sportId;
        this.name = name;
        this.level = level;
    }

    public Integer getSportId() {
        return sportId;
    }

    public void setSportId(Integer sportId) {
        this.sportId = sportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
