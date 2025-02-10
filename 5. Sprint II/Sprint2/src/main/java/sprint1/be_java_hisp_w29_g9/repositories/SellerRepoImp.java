package sprint1.be_java_hisp_w29_g9.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import sprint1.be_java_hisp_w29_g9.entities.Seller;

@AllArgsConstructor
@Data
@Repository
public class SellerRepoImp implements ISellerRepo {
  private List<Seller> sellers;
}
