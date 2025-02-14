package com.bootcamp.crud_joyeria.service;

import com.bootcamp.crud_joyeria.dto.request.CreateJewelRequestBody;
import com.bootcamp.crud_joyeria.dto.response.JewelResponseBody;
import com.bootcamp.crud_joyeria.exception.JewelNotFoundException;
import com.bootcamp.crud_joyeria.model.Jewel;
import com.bootcamp.crud_joyeria.repository.JewelryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JewelryService implements IJewelryService {

    private final JewelryRepository jewelryRepository;
    private final ObjectMapper objectMapper;

    @Override
    public String createJewel(CreateJewelRequestBody request) {
        Jewel jewel = objectMapper.convertValue(request, Jewel.class);
        jewelryRepository.save(jewel);
        return String.format("Jewel %s created with id %d", jewel.getName(), jewel.getId());
    }

    @Override
    public List<JewelResponseBody> getAllJewelry() {
        return jewelryRepository
                .findJewelsBySellableIsTrue()
                .stream()
                .map(jewel -> objectMapper.convertValue(jewel, JewelResponseBody.class))
                .toList();
    }

    @Override
    public JewelResponseBody updateJewel(long jewelId, CreateJewelRequestBody request) {
        jewelryRepository
                .findById(jewelId)
                .orElseThrow(() -> new JewelNotFoundException(jewelId));

        Jewel updatedJewel = objectMapper.convertValue(request, Jewel.class);
        updatedJewel.setId(jewelId);
        jewelryRepository.save(updatedJewel);

        return objectMapper.convertValue(updatedJewel, JewelResponseBody.class);
    }

    @Override
    public String deleteJewel(long jewelId) {
        Jewel jewel = jewelryRepository
                .findJewelByIdAndSellableIsTrue(jewelId)
                .orElseThrow(() -> new JewelNotFoundException(jewelId));

        jewel.setSellable(false);
        jewelryRepository.save(jewel);

        return String.format("Jewel with id %d has been deleted", jewelId);
    }
}
