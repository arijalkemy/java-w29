package com.example.joyerialasperlas.dto.out;

import com.example.joyerialasperlas.dto.JoyaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditadoDto {
    private JoyaDto joyaDto;
    private String mensaje;
}
