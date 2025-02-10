package org.melibootcamp.bonusej1.service;

import org.melibootcamp.bonusej1.dto.GarmentDto;
import org.melibootcamp.bonusej1.dto.MessageDto;
import org.melibootcamp.bonusej1.dto.SalesDto;
import org.melibootcamp.bonusej1.entity.Garment;
import org.melibootcamp.bonusej1.entity.Sale;
import org.melibootcamp.bonusej1.exception.GarmentAlreadyExist;
import org.melibootcamp.bonusej1.exception.GarmentNotFound;
import org.melibootcamp.bonusej1.exception.SaleNotFound;
import org.melibootcamp.bonusej1.repository.ISalesRepository;
import org.melibootcamp.bonusej1.utils.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesService implements ISalesService{
    @Autowired
    ISalesRepository repository;

    @Override
    public MessageDto saveSales(SalesDto salesDto) {
        Long id= salesDto.getId();
        if (repository.existsById(id)){
            throw new GarmentAlreadyExist("Ya existe Papu");
        }
        repository.save(MyMapper.saleDtoTosale(salesDto));
        return new MessageDto("Sale Guardada");
    }

    @Override
    public MessageDto updateSale(SalesDto salesDto, Long id) {
        if (repository.existsById(id)) {
            salesDto.setId(id);
            repository.save(MyMapper.saleDtoTosale(salesDto));
            return new MessageDto("Sale updated");
        }
        throw new SaleNotFound("No se encontro");
    }

    @Override
    public MessageDto deleteSaleById(Long id) {
        repository.deleteById(id);
        return new MessageDto("Sale Deleted");
    }
    @Override
    public List<SalesDto> getAllSales() {
        List<Sale> sales =repository.findAll();
        if (sales.isEmpty()) {
            throw new GarmentNotFound("No sale found");
        }
        return sales.stream().map(MyMapper::salesToSaleDto).toList();
    }
    @Override
    public SalesDto getSaleById(Long id) {
        Optional<Sale> sale = repository.findPrendasById(id);
        if (sale.isEmpty()) {
            throw new SaleNotFound("Sale not found");
        }
        return MyMapper.salesToSaleDto(sale.get());
    }
    @Override
    public List<SalesDto> getSaleBySize(String size){
        List<Sale> sales= repository.findGarmentBySize(size);
        if (sales.isEmpty()){
            throw new GarmentNotFound("Garment not found");
        }
        return sales.stream().map(MyMapper::salesToSaleDto).toList();
    }
    @Override
    public List<SalesDto> getSaleByNameContainingIgnoreCase(String name){
        List<Sale> sales= repository.findGarmentByNameContainingIgnoreCase(name);
        if (sales.isEmpty()){
            throw new GarmentNotFound("Garment not found");
        }
        return sales.stream().map(MyMapper::salesToSaleDto).toList();
    }
}
