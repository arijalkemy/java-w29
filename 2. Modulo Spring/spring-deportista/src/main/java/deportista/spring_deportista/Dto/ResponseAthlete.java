package deportista.spring_deportista.Dto;

public class ResponseAthlete {
    private String userName;
    private String lastname;
    private String sportName;

    public ResponseAthlete(String userName, String lastname, String sportName) {
        this.userName = userName;
        this.lastname = lastname;
        this.sportName = sportName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }
}
