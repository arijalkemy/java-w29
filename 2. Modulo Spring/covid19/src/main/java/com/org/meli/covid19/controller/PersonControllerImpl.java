package com.org.meli.covid19.controller;

import com.org.meli.covid19.dto.RiskGroupPersonDto;
import com.org.meli.covid19.service.IPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonControllerImpl{
    private final IPersonService personService;

    public PersonControllerImpl(IPersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskGroupPersonDto>> getRiskGroupPerson() {
        return new ResponseEntity<>(personService.getListRiskGroupPerson(), HttpStatus.OK);
    }
}
