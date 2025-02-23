package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class FindControllerTests {

    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    public void findTest() {
        String query = "query";

        controller.find(query);

        verify(service, atLeastOnce()).find(query);
    }
}
