package spring.codigoMorse.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.codigoMorse.domain.CodigoMorse;

@RestController
public class CodMorseController {

    @GetMapping("/codigoMorse")
    public String codigoMorseController(
            @RequestBody JsonNode body
    ) {
        CodigoMorse morse = new CodigoMorse(body.get("codigo").asText());
        return morse.decode();
    }
}
