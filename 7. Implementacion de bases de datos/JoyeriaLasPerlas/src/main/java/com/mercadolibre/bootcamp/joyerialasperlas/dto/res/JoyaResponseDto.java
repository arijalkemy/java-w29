package com.mercadolibre.bootcamp.joyerialasperlas.dto.res;

import com.mercadolibre.bootcamp.joyerialasperlas.model.Joya;

public class JoyaResponseDto {

    private Integer id;

    public JoyaResponseDto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public static JoyaResponseDto from(Joya j) {
        return new JoyaResponseDto(
                j.getId()
        );
    }

}
