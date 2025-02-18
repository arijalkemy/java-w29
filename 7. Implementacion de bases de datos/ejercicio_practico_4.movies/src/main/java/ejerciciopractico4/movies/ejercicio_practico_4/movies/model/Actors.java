package ejerciciopractico4.movies.ejercicio_practico_4.movies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "actors")
public class Actors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Double rating;
    @ManyToOne
    @JoinColumn(name = "favorite_movie_id", referencedColumnName = "id")
    private Movies favoriteMovie;
    @ManyToMany(mappedBy = "actors")
    private List<Movies> movies;
    @ManyToMany(mappedBy = "actors")
    private List<Episodes> episodes;

}
