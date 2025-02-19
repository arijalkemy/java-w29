package com.example.ThePearls.service;

import com.example.ThePearls.dto.request.JewelDtoRequest;
import com.example.ThePearls.dto.response.JewelDtoResponse;
import com.example.ThePearls.dto.response.NewJewelDto;
import com.example.ThePearls.entity.Jewel;
import com.example.ThePearls.repository.IJewelRepository;
import com.example.ThePearls.utils.JewelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JewelServiceImpl implements IJewelService {

    private final IJewelRepository jewelRepository;

    @Override
    public NewJewelDto addNewJewel(JewelDtoRequest request) {
        Jewel jewel = jewelRepository.save(JewelMapper.INSTANCE.jewelDtoToJewel(request));

        return JewelMapper.INSTANCE.jewelToJewelDto(jewel);
    }

    @Override
    public List<JewelDtoResponse> getAllJewelry() {
        List<Jewel> jewelry = jewelRepository.findAll().stream().filter(Jewel::getSaleOrNot).toList();

        return jewelry.stream().map(JewelMapper.INSTANCE::jewelToJewelDtoResponse).toList();
    }

    @Override
    public Jewel getJewelById(Long id) {
        return jewelRepository.getReferenceById(id);
    }

    @Override
    public NewJewelDto deleteJewelById(Long id) {
        Jewel jewel = jewelRepository.getReferenceById(id);
        jewel.setSaleOrNot(false);
        jewel = jewelRepository.save(jewel);
        return JewelMapper.INSTANCE.jewelToJewelDto(jewel);
    }

    @Override
    public JewelDtoResponse updateJewelById(Long id, JewelDtoRequest request) {
        Jewel newJewel = JewelMapper.INSTANCE.jewelDtoToJewel(request);
        newJewel.setId_number(id);
        return JewelMapper.INSTANCE.jewelToJewelDtoResponse(jewelRepository.save(newJewel));
    }
}
