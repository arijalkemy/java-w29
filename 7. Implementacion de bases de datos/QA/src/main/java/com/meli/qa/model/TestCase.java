package com.meli.qa.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "test_case")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case")
    private Long idCase;

    private String description;

    private Boolean tested;

    private Boolean passed;

    @Column(name = "number_of_tries")
    private int numberOfTries;

    @Column(name = "last_update")
    private LocalDate lastUpdate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "test_done_by",
            joinColumns = @JoinColumn(referencedColumnName = "id_case"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id")
    )
    private Set<User> testDoneBy;

}
