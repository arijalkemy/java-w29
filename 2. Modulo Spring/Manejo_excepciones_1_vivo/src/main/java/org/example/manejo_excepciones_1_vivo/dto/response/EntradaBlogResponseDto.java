package org.example.manejo_excepciones_1_vivo.dto.response;

import lombok.Builder;
import lombok.Data;
import org.example.manejo_excepciones_1_vivo.entity.EntradaBlog;

import java.util.Date;

@Data
@Builder
public class EntradaBlogResponseDto {
    private String message;
    private EntradaBlog entradaBlog;
}
