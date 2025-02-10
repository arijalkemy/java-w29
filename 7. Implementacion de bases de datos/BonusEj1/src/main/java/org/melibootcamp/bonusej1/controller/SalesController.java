package org.melibootcamp.bonusej1.controller;

import org.melibootcamp.bonusej1.service.ISalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesController {
    @Autowired
    ISalesService service;
}
