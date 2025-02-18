package hql.showroom.repository;

import hql.showroom.model.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IClothingRepository extends JpaRepository<Clothing, Long> {

    Optional<Clothing> findByCode(String code);

    List<Clothing> findBySize(String size);

    List<Clothing> findByNameContainingIgnoreCase(String name);
}
