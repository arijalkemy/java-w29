package com.example.showroom.service;

import com.example.showroom.model.dto.SaleDTO;
import com.example.showroom.model.entity.Sale;
import com.example.showroom.repository.IClotheRepository;
import com.example.showroom.repository.ISaleRepository;
import com.example.showroom.utils.mappers.SaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements ISaleService {
    @Autowired
    private ISaleRepository saleRepository;
    @Autowired
    private IClotheRepository clotheRepository;

    @Override
    public SaleDTO createSale(SaleDTO saleDTO) {
        saleDTO.getClothes().forEach(clotheDTO -> {
            if (!clotheRepository.existsById(clotheDTO.getCode())) {
                throw new RuntimeException("Clothe not found");
            }
        });

        return SaleMapper.toSaleDTO(saleRepository.save(
                SaleMapper.toSale(saleDTO)
        ));
    }

    @Override
    public SaleDTO getSale(Long number) {
        return SaleMapper.toSaleDTO(saleRepository.findById(number).get());
    }

    @Override
    public List<SaleDTO> getSales() {
        return SaleMapper.toSaleDTOList(saleRepository.findAll());
    }

    @Override
    public SaleDTO updateSale(SaleDTO saleDTO, Long number) {
        Sale sale = saleRepository.findById(number).get();
        Long saleNumber = sale.getNumber();
        sale = SaleMapper.toSale(saleDTO);
        sale.setNumber(saleNumber);

        return SaleMapper.toSaleDTO(saleRepository.save(sale));
    }

    @Override
    public void deleteSale(Long number) {
        saleRepository.deleteById(number);
    }
}
