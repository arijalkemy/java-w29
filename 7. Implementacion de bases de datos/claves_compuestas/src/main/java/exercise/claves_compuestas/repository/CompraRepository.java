package exercise.claves_compuestas.repository;

import exercise.claves_compuestas.entity.Compra;
import exercise.claves_compuestas.entity.CompraPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, CompraPK> {
}
