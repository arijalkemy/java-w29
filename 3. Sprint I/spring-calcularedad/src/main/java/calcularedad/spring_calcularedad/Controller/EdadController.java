package calcularedad.spring_calcularedad.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadController {


    @GetMapping ("{day}/{month}/{year}")
    public ResponseEntity<?> calcularEdad(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        LocalDate birthday = LocalDate.of(year, month, day);

        Period edad = Period.between(birthday, LocalDate.now());
        return edad.getYears() > 0 ? ResponseEntity.ok(edad.getYears()) : ResponseEntity.badRequest().build();

    }


}
