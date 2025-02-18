package ejerciciopractico4.movies.ejercicio_practico_4.movies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    private String title;
    @Column(name ="release_date")
    private Date releaseDate;
    @Column(name="end_date")
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", nullable = false)
    private Genres genre;
    @OneToMany(mappedBy = "serie")
    private List<Seasons> seasons;
}
