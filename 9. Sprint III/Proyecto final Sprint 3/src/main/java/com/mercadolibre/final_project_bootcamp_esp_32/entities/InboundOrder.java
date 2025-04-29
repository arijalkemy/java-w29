package com.mercadolibre.final_project_bootcamp_esp_32.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InboundOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer orderNumber;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "section_code")
    private Section section;

    @ManyToOne
    @JoinColumn(name = "internal_user_id")
    private InternalUser internalUser;

}
