package com.example.qatester.service;

import com.example.qatester.dto.in.TesterDto;
import com.example.qatester.dto.out.MessageDto;

import javax.validation.Valid;

public interface ITesterService {
    MessageDto addTester(@Valid TesterDto testerDto);
}
