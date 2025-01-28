package sprint1.be_java_hisp_w29_g9.services;


import sprint1.be_java_hisp_w29_g9.dtos.products.requests.CreateProductPostRequestDTO;
import sprint1.be_java_hisp_w29_g9.dtos.products.requests.CreatePromoProductPostRequestDTO;
import sprint1.be_java_hisp_w29_g9.dtos.products.responses.PostDiscountDTO;
import sprint1.be_java_hisp_w29_g9.dtos.products.responses.ProductsFollowedDTO;
import sprint1.be_java_hisp_w29_g9.dtos.products.responses.PromosCountDTO;

import java.util.List;

public interface IProductService {
  ProductsFollowedDTO getPostsFollowedByDate(Integer userId, String order);
  PromosCountDTO promoPublicationsCountByUser(Integer userId);
  Boolean addProductInPromo(CreatePromoProductPostRequestDTO productInPromo);
  void addNewPublication(CreateProductPostRequestDTO publicationDTO);
  List<PostDiscountDTO> promoDiscountCalculate(Double discount);
}
