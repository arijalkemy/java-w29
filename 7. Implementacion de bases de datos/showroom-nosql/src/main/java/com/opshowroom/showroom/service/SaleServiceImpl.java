package com.opshowroom.showroom.service;

import com.opshowroom.showroom.domain.Clothe;
import com.opshowroom.showroom.domain.Sale;
import com.opshowroom.showroom.dto.request.SaleDTO;
import com.opshowroom.showroom.dto.response.SaleResDTO;
import com.opshowroom.showroom.exception.InvalidDateFormatException;
import com.opshowroom.showroom.exception.SaleNotFoundException;
import com.opshowroom.showroom.exception.SalesNotFoundException;
import com.opshowroom.showroom.repository.IClotheRepository;
import com.opshowroom.showroom.repository.ISaleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements ISaleService{

    private final ISaleRepository saleRepository;
    private final IClotheRepository clotheRepository;
    private final ModelMapper mp;

    @Autowired
    public SaleServiceImpl(ISaleRepository saleRepository, IClotheRepository clotheRepository) {
        this.saleRepository = saleRepository;
        this.clotheRepository = clotheRepository;
        this.mp = new ModelMapper();
    }

    @Override
    public SaleResDTO createSale(SaleDTO saleDto) {
        Sale sale = mp.map(saleDto, Sale.class);
        System.out.println(sale.getNumber());
        Sale saleSaved = saleRepository.save(sale);
        return mp.map(saleSaved, SaleResDTO.class);
    }

    @Override
    public List<Sale> getAllSales() {
        Page<Sale> sales = saleRepository.findAll(PageRequest.of(0, 10));
        return sales.getContent();
    }

    @Override
    public SaleResDTO getSaleById(Long id) {
        Optional<Sale> sale = saleRepository.findById(id);
        if (sale.isEmpty()) {
            throw new SaleNotFoundException(id);
        }
        return mp.map(sale.get(), SaleResDTO.class);
    }

    @Override
    public SaleResDTO updateSale(Long number, SaleDTO saleDto) {
        Optional<Sale> optionalSale = saleRepository.findById(number);
        if (optionalSale.isEmpty()) {
            throw new SaleNotFoundException(number);
        }
        Sale sale = optionalSale.get();
        sale.setDate(saleDto.getDate());
        sale.setTotal(saleDto.getTotal());
        sale.setPaymentMethod(saleDto.getPaymentMethod());
        sale.setProducts(saleDto.getProducts());
        Sale saleSaved = saleRepository.save(sale);
        return mp.map(saleSaved, SaleResDTO.class);
    }

    @Override
    public void deleteSale(Long number) {
        Optional<Sale> optionalSale = saleRepository.findById(number);
        if (optionalSale.isEmpty()) {
            throw new SaleNotFoundException(number);
        }
        saleRepository.delete(optionalSale.get());
    }

    @Override
    public List<SaleResDTO> getSalesByDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parsedDate;
        try {
            parsedDate = LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidDateFormatException();
        }
        List<Sale> sales = saleRepository.findByDate(parsedDate);
        if (sales.isEmpty()) {
            throw new SalesNotFoundException();
        }
        return sales.stream().map(sale -> mp.map(sale, SaleResDTO.class)).toList();
    }

    @Override
    public List<Clothe> getClothesBySale(Long number) {
        Optional<Sale> optionalSale = saleRepository.findById(number);
        if (optionalSale.isEmpty()) {
            throw new SaleNotFoundException(number);
        }
        Sale sale = optionalSale.get();
        List<Long> clothesIds = sale.getProducts();
        Iterable<Clothe> clothesIterable = clotheRepository.findAllById(clothesIds);

        return StreamSupport.stream(clothesIterable.spliterator(), false)
            .collect(Collectors.toList());
    }
}
