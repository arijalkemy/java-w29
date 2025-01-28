package org.example.deportes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor

public class DeportistaDTO {

    private String nombreCompleto;
    private String deporte;

}


