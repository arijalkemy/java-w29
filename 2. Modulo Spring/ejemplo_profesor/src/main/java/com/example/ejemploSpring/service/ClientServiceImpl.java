package com.example.ejemploSpring.service;

import com.example.ejemploSpring.dto.ClientDto;
import com.example.ejemploSpring.dto.response.ClientSavedDto;
import com.example.ejemploSpring.entity.Client;
import com.example.ejemploSpring.exception.ClientNotFoundException;
import com.example.ejemploSpring.repository.ClientRepositoryImpl;
import com.example.ejemploSpring.repository.IClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements IClientService{

    private IClientRepository repository;

    public ClientServiceImpl (IClientRepository repository){
        this.repository = repository;
    }

    @Override
    public ClientDto getClientByName(String name) {
        ObjectMapper om = new ObjectMapper();
        Optional<Client> oClient= repository.findClientByName(name);
        if(oClient.isEmpty()){
            throw new ClientNotFoundException("El usuario no existe.");
        }
        return om.convertValue(oClient.get(), ClientDto.class);
    }

    @Override
    public ClientSavedDto saveClient(ClientDto clientDto) {
        ObjectMapper om = new ObjectMapper();
        Client client = om.convertValue(clientDto, Client.class);
        repository.addClient(client);
        return new ClientSavedDto("El Cliente fue guardado con éxito!",clientDto);
    }
}
