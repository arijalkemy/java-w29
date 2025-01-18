package com.spring_p1.sports.dto;

import java.io.Serializable;

public class SportPersonDTO implements Serializable {
    private String fullName;
    private String sportName;

    public SportPersonDTO(String fullName, String sportName) {
        this.fullName = fullName;
        this.sportName = sportName;
    }

    // Getters and setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    @Override
    public String toString() {
        return "SportPersonDTO [fullName=" + fullName + ", sportName=" + sportName + "]";
    }
}
