package com.myself.practicing.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myself.practicing.domain.DTOs.ProductDTO;
import com.myself.practicing.domain.models.Product;
import com.myself.practicing.domain.repositories.ProductRepository;

@Service 
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllService()
    {
        return repository.findAllProducts();
    }

    public Product getByIdService(Long id)
    {
        return repository.findProductById(id);
    }

    public Product postService(ProductDTO product)
    {
        return repository.createProduct(product);
    }

    public Product putService(Long id, ProductDTO product)
    {
        return repository.updateProduct(id, product);
    }

    public void deleteService(Long id)
    {
        repository.deleteProduct(id);
    }

}
