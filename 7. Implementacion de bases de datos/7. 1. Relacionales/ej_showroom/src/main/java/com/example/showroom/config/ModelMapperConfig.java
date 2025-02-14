package com.example.showroom.config;

import com.example.showroom.dto.ClotheDto;
import com.example.showroom.dto.SaleDto;
import com.example.showroom.exception.NotFoundException;
import com.example.showroom.model.Clothe;
import com.example.showroom.model.Sale;
import com.example.showroom.repository.BrandRepository;
import com.example.showroom.repository.PaymentMethodRepository;
import org.springframework.context.annotation.Configuration;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;


@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(
            BrandRepository brandRepository,
            PaymentMethodRepository paymentMethodRepository) {
        ModelMapper mapper = new ModelMapper();

        // Configuración global para no mapear los valores null
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

        // Configuración para mapear de ClotheDto a Clothe buscando Brand por nombre
        mapper.addMappings(new PropertyMap<ClotheDto, Clothe>() {
            @Override
            protected void configure() {
                using(ctx -> {
                    String brandName = (String) ctx.getSource();
                    return brandRepository.findByName(brandName)
                            .orElseThrow(() -> new NotFoundException("Brand not found"));
                }).map(source.getBrand(), destination.getBrand());
            }
        });

        // Configuración para mapear de SaleDto a Sale buscando Payment method por nombre
        mapper.addMappings(new PropertyMap<SaleDto, Sale>() {
            @Override
            protected void configure() {
                using(ctx -> {
                    String paymentMethodName = (String) ctx.getSource();
                    return paymentMethodRepository.findByName(paymentMethodName)
                            .orElseThrow(() -> new NotFoundException("Payment Method not found"));
                }).map(source.getPaymentMethod(), destination.getPaymentMethod());
            }
        });

        // Configuración para mapear de Clothe a ClotheDto asignando el nombre de brand en lugar del objeto
        mapper.addMappings(new PropertyMap<Clothe, ClotheDto>() {
            @Override
            protected void configure() {
                map().setBrand(source.getBrand().getName());
            }
        });

        // Configuración para mapear el string del payment method en SaleDto
        mapper.addMappings(new PropertyMap<Sale, SaleDto>() {
            @Override
            protected void configure() {
                map().setPaymentMethod(source.getPaymentMethod().getName());
            }
        });

        return mapper;
    }
}

