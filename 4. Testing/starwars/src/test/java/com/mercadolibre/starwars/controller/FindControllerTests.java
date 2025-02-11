package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FindControllerTests {

    @Mock
    FindService findService;
}
