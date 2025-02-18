package ejerciciopractico4.movies.ejercicio_practico_4.movies.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "genres")
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    private String name;
    private Integer rating;
    private Boolean active;
}
