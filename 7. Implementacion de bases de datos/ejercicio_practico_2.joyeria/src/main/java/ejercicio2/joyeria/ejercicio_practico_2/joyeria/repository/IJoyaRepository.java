package ejercicio2.joyeria.ejercicio_practico_2.joyeria.repository;

import ejercicio2.joyeria.ejercicio_practico_2.joyeria.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya,Long> {
}
