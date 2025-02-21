package ejercicios_extra_p1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ejercicios_extra_p1.entities.Sale;

public interface ISaleRepository extends JpaRepository<Sale, Long> {
  
}
