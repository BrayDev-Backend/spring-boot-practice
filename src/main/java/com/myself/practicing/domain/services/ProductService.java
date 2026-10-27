package com.myself.practicing.domain.services;

import java.util.List;
import java.util.ServiceLoader.Provider;

import org.springframework.stereotype.Service;

import com.myself.practicing.domain.models.Product;
import com.myself.practicing.domain.repositories.ProductRepository;

@Service 
public class ProductService implements ProductRepository{

    @Override 
    public List<Product> findAllProducts()
    {
        
    }

}
