package ejerciciopractico4.movies.ejercicio_practico_4.movies.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "seasons")
public class Seasons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    private String title;
    private Integer number;
    @Column(name ="release_date")
    private Date releaseDate;
    @Column(name="end_date")
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "serie_id", referencedColumnName = "id", nullable = false)
    private Serie serie;
    @OneToMany(mappedBy = "season")
    private List<Episodes> episodes;

}
