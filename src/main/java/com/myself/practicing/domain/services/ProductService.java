package com.myself.practicing.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myself.practicing.domain.DTOs.ProductDTO;
import com.myself.practicing.domain.models.Product;
import com.myself.practicing.infrastructure.repositories.InMemoryProductRepository;

@Service 
public class ProductService{

    private InMemoryProductRepository repository;

    public List<Product> getAll()
    {
        return repository.findAllProducts();
    }

    public Product getProductById(Long id)
    {
        return repository.findProductById(id);
    }

    public Product postProduct(ProductDTO product)
    {
        return repository.createProduct(product);
    }

    public Product patchProduct(Long id, ProductDTO product)
    {
        return repository.updateProduct(id, product);
    }

    public void deleteProduct(Long id)
    {
        repository.deleteProduct(id);
    }

}
