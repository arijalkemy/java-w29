package com.spring_p2.covid.model;

public class Symptom {
    private Integer code;
    private String name;
    private Integer severity;

    // Constructor
    public Symptom(Integer code, String name, Integer severity) {
        this.code = code;
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return "Symptom [code=" + code + ", name=" + name + ", severity=" + severity + "]";
    }

    // Getters and setters
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }
}
