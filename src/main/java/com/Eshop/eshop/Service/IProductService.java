package com.Eshop.eshop.Service;

import com.Eshop.eshop.Dto.ModelDTO;
import com.Eshop.eshop.Dto.ProductDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IProductService {
    List<ProductDTO> getAllProducts();

    ProductDTO addProduct(ProductDTO productDTO);

    ProductDTO getProductById(Long id);

    ProductDTO updateProductrById(Long id, Map<String, Object> fields);

    ProductDTO deleteProductById(Long id);
}
