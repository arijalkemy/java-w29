package com.mercadolibre.final_project_bootcamp_esp_2.dto.auth;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {
    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}