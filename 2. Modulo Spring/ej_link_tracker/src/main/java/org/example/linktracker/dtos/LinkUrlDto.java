package org.example.linktracker.dtos;

import jakarta.validation.constraints.Pattern;

public record LinkUrlDto(

        // Regex -> https://regexr.com/39nr7

        // [(http(s)?):\\/\\/(www\\.)?
        // http://
        // https://
        // www. (opcional)

        // a-zA-Z0-9@:%._\\+~#=]{2,256}
        // Cualquier letra mayúscula o minúcula y caracteres especiales

        // \\.[a-z]{2,6}\\b
        // Busca el punto . y dominios (.com, .org, .io, etc)

        // ([-a-zA-Z0-9@:%_\\+.~#?&//=]*)
        // Caracteres opcionales (letras, números y caracteres especiales) que pueden aparecer después del dominio
        @Pattern(
                regexp = "(http(s)?):\\/\\/(www\\.)?[a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)",
                message = "Debe ingresar una URL válida"
        )
        String url) {
}
