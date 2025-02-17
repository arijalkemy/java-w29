package com.bootcampw29.jewelry.service;

import com.bootcampw29.jewelry.constants.Messages;
import com.bootcampw29.jewelry.dto.request.JewelRequestDTO;
import com.bootcampw29.jewelry.dto.response.JewelCreatedDTO;
import com.bootcampw29.jewelry.dto.response.JewelResponseDTO;
import com.bootcampw29.jewelry.exception.NotFoundException;
import com.bootcampw29.jewelry.model.Jewel;
import com.bootcampw29.jewelry.repository.JewelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JewelServiceImpl implements JewelService {

    private final JewelRepository jewelRepository;
    private final ModelMapper modelMapper;

    public JewelServiceImpl(JewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public JewelCreatedDTO createJewel(JewelRequestDTO jewelRequestDTO) {
        Jewel jewel = modelMapper.map(jewelRequestDTO, Jewel.class);
        Jewel savedJewel = jewelRepository.save(jewel);
        return new JewelCreatedDTO(savedJewel.getId());
    }

    @Override
    public JewelResponseDTO updateJewel(JewelRequestDTO jewelRequestDTO, Long id) {
        Jewel jewelFound = jewelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(Messages.JEWEL_NOT_FOUND, id)));

        modelMapper.map(jewelRequestDTO, jewelFound);
        Jewel updatedJewel = jewelRepository.save(jewelFound);
        return modelMapper.map(updatedJewel, JewelResponseDTO.class);
    }

    @Override
    public List<JewelResponseDTO> findSaleJewels() {
        List<Jewel> jewels = jewelRepository.findAllByIsForSaleTrue();
        return jewels.stream()
                .map(jewel -> modelMapper.map(jewel, JewelResponseDTO.class))
                .toList();
    }

    @Override
    public void deleteJewel(Long id) {
        Jewel jewelFound = jewelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(Messages.JEWEL_NOT_FOUND, id)));

        jewelFound.setIsForSale(false);
        jewelRepository.save(jewelFound);
    }
}
