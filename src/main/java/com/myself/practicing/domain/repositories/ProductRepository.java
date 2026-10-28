package com.myself.practicing.domain.repositories;

import java.util.List;

import com.myself.practicing.domain.DTOs.ProductDTO;
import com.myself.practicing.domain.models.Product;

public interface ProductRepository {

    List<Product> findAllProducts();
    Product findProductById(Long id);
    Product createProduct(ProductDTO product);
    Product updateProduct(Long id, ProductDTO product);
    void deleteProduct(Long id);

}
