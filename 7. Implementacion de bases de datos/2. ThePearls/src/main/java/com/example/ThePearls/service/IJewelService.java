package com.example.ThePearls.service;

import com.example.ThePearls.dto.request.JewelDtoRequest;
import com.example.ThePearls.dto.response.JewelDtoResponse;
import com.example.ThePearls.dto.response.NewJewelDto;
import com.example.ThePearls.entity.Jewel;

import java.util.List;

public interface IJewelService {
    NewJewelDto addNewJewel(JewelDtoRequest request);
    List<JewelDtoResponse> getAllJewelry();
    Jewel getJewelById(Long id);
    NewJewelDto deleteJewelById(Long id);
    JewelDtoResponse updateJewelById(Long id, JewelDtoRequest request);
}