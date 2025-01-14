package com.obtener.edad.controller;

import com.obtener.edad.models.BirthdayDTO;
import com.obtener.edad.service.PersonaService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonaController {
    private final PersonaService personaService;
    public PersonaController(final PersonaService personaService) {this.personaService = personaService;}


    @GetMapping("/{day}/{month}/{year}")
    public String getAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
        Integer age = personaService.calculateAge(year, month,day);
        return "Age: " + age;
    }

    @PostMapping("/AddAge")
    public String getAgeWhitUuid(@RequestBody BirthdayDTO birthday) {

        return personaService.addBirthday(birthday);
    }

    @GetMapping("/GetAge/{uuid}")
    public String getAge(@PathVariable String uuid) {
        Integer age = personaService.getAge(uuid);
        return "Age: " + age;
    }


}
