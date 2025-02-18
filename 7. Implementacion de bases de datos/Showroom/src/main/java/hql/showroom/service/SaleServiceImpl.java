package hql.showroom.service;
import hql.showroom.dto.request.SaleRequestDTO;
import hql.showroom.dto.response.SaleResponseDTO;
import hql.showroom.model.Clothing;
import hql.showroom.model.Sale;
import hql.showroom.repository.IClothingRepository;
import hql.showroom.repository.ISaleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleServiceImpl {

    private final ISaleRepository saleRepository;
    private final IClothingRepository clothingRepository;

    public SaleServiceImpl(ISaleRepository saleRepository, IClothingRepository clothingRepository) {
        this.saleRepository = saleRepository;
        this.clothingRepository = clothingRepository;
    }
    public SaleResponseDTO createSale(SaleRequestDTO saleRequestDTO) {
        Sale sale = new Sale();
        sale.setNumber(saleRequestDTO.getNumber());
        sale.setDate(saleRequestDTO.getDate());
        sale.setTotal(saleRequestDTO.getTotal());
        sale.setPaymentMethod(saleRequestDTO.getPaymentMethod());

        List<Clothing> clothingList = clothingRepository.findAllById(saleRequestDTO.getClothingList());
        sale.setClothingList(clothingList);

        Sale savedSale = saleRepository.save(sale);
        return new SaleResponseDTO(savedSale);
    }

    public List<Sale> getAllSalesWithClothing() {
        return saleRepository.getAllSalesWithClothing();
    }

    public List<Sale> getSalesByDate(LocalDate date) {
        return saleRepository.getSalesByDate(date);
    }

    public List<Sale> getSalesByPaymentMethod(String paymentMethod) {
        return saleRepository.getSalesByPaymentMethod(paymentMethod);
    }

    public List<Clothing> getClothingSoldBetweenDates(LocalDate startDate, LocalDate endDate) {
        return saleRepository.getClothingSoldBetweenDates(startDate, endDate);
    }
}
