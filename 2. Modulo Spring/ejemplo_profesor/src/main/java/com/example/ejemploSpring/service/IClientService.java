package com.example.ejemploSpring.service;

import com.example.ejemploSpring.dto.ClientDto;
import com.example.ejemploSpring.dto.response.ClientSavedDto;

public interface IClientService {
    ClientDto getClientByName(String name);
    ClientSavedDto saveClient(ClientDto client);
}
