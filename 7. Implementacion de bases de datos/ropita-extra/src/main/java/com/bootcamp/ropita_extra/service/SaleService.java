package com.bootcamp.ropita_extra.service;

import com.bootcamp.ropita_extra.dto.ClothesDto;
import com.bootcamp.ropita_extra.dto.SaleRequestDto;
import com.bootcamp.ropita_extra.dto.SaleResponseDto;
import com.bootcamp.ropita_extra.exception.SaleNotFoundException;
import com.bootcamp.ropita_extra.model.Clothes;
import com.bootcamp.ropita_extra.model.Sale;
import com.bootcamp.ropita_extra.repository.jpa.ClothesRepository;
import com.bootcamp.ropita_extra.repository.jpa.SalesRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService implements ISalesService{
    private final SalesRepository salesRepository;
    private final ClothesRepository clothesRepository;
    private final ModelMapper mapper;

    @Autowired
    public SaleService(SalesRepository repo, ClothesRepository clothesRepository) {
        this.salesRepository = repo;
        this.clothesRepository = clothesRepository;
        this.mapper = new ModelMapper();
    }


    @Override
    public List<SaleResponseDto> findAllSales() {
        return salesRepository.findAll().stream().map(s -> mapper.map(s, SaleResponseDto.class)).toList();
    }

    @Override
    public SaleResponseDto findSaleById(String id) {
        return salesRepository.findById(id).map(s -> mapper.map(s, SaleResponseDto.class)).orElseThrow(SaleNotFoundException::new);
    }

    @Override
    public void deleteSaleById(String id) {
        Sale sale = salesRepository.findById(id).orElseThrow(SaleNotFoundException::new);
        salesRepository.delete(sale);
    }

    @Override
    public SaleResponseDto saveSale(SaleRequestDto saleRequestDto) {
        Sale sale = mapper.map(saleRequestDto, Sale.class);
        List<Clothes> clothes = saleRequestDto.getClothes().stream().map(c -> clothesRepository.findById(c.getCode()).orElseThrow(SaleNotFoundException::new)).toList();
        sale.setClothes(clothes);
        sale.setDate(LocalDate.now());
        sale.setTotal(sale.getClothes().stream().mapToDouble(Clothes::getPrice).sum());
        Sale saved = salesRepository.save(sale);
        return mapper.map(saved, SaleResponseDto.class);
    }

    @Override
    public SaleResponseDto updateSale(String id, SaleRequestDto saleRequestDto) {
        Sale sale = salesRepository.findById(id).orElseThrow(SaleNotFoundException::new);
        sale.setPaymentMethod(saleRequestDto.getPaymentMethod());
        for (int i = 0; i < sale.getClothes().size(); i++){
            Clothes c = sale.getClothes().get(i);
            c.setName(saleRequestDto.getClothes().get(i).getName());
            c.setType(saleRequestDto.getClothes().get(i).getType());
            c.setBrand(saleRequestDto.getClothes().get(i).getBrand());
            c.setColor(saleRequestDto.getClothes().get(i).getColor());
            c.setSize(saleRequestDto.getClothes().get(i).getSize());
            c.setAmount(saleRequestDto.getClothes().get(i).getAmount());
            c.setPrice(saleRequestDto.getClothes().get(i).getPrice());
        }
        salesRepository.save(sale);
        return mapper.map(sale, SaleResponseDto.class);
    }

    @Override
    public List<ClothesDto> findClothesFromSale(String id) {
        return salesRepository.findById(id).orElseThrow(SaleNotFoundException::new).getClothes().stream().map(c -> mapper.map(c, ClothesDto.class)).toList();
    }
}
