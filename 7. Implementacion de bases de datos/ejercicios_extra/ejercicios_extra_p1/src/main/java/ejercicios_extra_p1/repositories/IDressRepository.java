package ejercicios_extra_p1.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ejercicios_extra_p1.entities.Dress;

public interface IDressRepository extends JpaRepository<Dress, Long> {
  List<Dress> findAllBySize(String size);
  List<Dress> findAllByNameContainingIgnoreCase(String name);
}
