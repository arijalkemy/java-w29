package org.example.linktracker.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Link {

    private Long id;

    private String url;

    private String password;

    @Builder.Default
    private Boolean valid = true;

    @Builder.Default
    private Integer cantidadRedirecciones = 0;

    public void redireccionar() {
        this.cantidadRedirecciones++;
    }

    public Boolean isPasswordValid(String password) {
        return this.password.equals(password);
    }

    public Boolean isValid() {
        return valid;
    }

}
