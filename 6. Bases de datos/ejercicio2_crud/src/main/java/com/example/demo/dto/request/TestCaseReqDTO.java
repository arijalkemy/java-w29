package com.example.demo.dto.request;

import java.time.LocalDate;

public record TestCaseReqDTO(String description, Boolean tested, Boolean passed,
                                 String status, int number_of_tries, LocalDate last_update) {}

