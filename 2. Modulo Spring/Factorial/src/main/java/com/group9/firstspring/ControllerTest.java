package com.group9.firstspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factorial")
public class ControllerTest {
    @GetMapping("/{number}")
    public Long obtenerFactorial(@PathVariable Long number) {
        if (number == 0) {
            return 1L;
        }
        return number * obtenerFactorial(number - 1);
    }

}
