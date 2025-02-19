package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
public class Curse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curse_id")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "curses", fetch = FetchType.EAGER)
    Set<Student> students;
}
