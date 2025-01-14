package com.bootcamp.birthday.Controller;

import com.bootcamp.birthday.Models.BirthdayQuery;
import com.bootcamp.birthday.Service.BirthdayService;
import org.springframework.web.bind.annotation.*;

@RestController
public class BirthdayController {

    private final BirthdayService birthdayService;

    public BirthdayController(BirthdayService birthdayService) {
        this.birthdayService = birthdayService;
    }

    @GetMapping("/{day}/{month}/{year}")
    public String dayMonthYear(
            @PathVariable Integer day,
            @PathVariable Integer month,
            @PathVariable Integer year) {

        return "Edad: " + birthdayService.getAge(day, month, year);

    }

    @PostMapping("/generate")
    public String addBirthday(@RequestBody BirthdayQuery query) {
        return "Query code: " + birthdayService.generateBirthday(query);
    }

    @GetMapping("/{uuid}")
    public String findBirthdayById(@PathVariable String uuid) {
        return "Edad: " + birthdayService.getAgeWithCode(uuid);
    }





}
