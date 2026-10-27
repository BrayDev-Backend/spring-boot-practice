package com.myself.practicing.domain.repositories;

import java.util.List;

import com.myself.practicing.domain.models.Product;

public interface ProductRepository {

    List<Product> findAllProducts();
    Product finProductById(int id);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(int id);

}
