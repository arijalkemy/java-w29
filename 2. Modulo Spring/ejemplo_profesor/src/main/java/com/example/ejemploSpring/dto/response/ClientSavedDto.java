package com.example.ejemploSpring.dto.response;

import com.example.ejemploSpring.dto.ClientDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientSavedDto {
    private String message;
    private ClientDto clientDto;
}
