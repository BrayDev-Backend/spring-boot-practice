package com.myself.practicing.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myself.practicing.domain.DTOs.ProductDTO;
import com.myself.practicing.domain.models.Product;
import com.myself.practicing.domain.services.ProductService;

@RestController 
@RequestMapping("/api/v2")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products") 
    public List<Product> getAll()
    {
        return productService.getAllService();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id)
    {
        Product product = productService.getByIdService(id);
        
        if (product != null) {
            return ResponseEntity.ok(product);
        }

        return ResponseEntity.notFound().build();
    } 

    @PostMapping("/products")
    public ResponseEntity<Product> postProduct(@RequestBody ProductDTO productDTO)
    {
        Product product = productService.postService(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> putProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO)
    {
        Product product = productService.putService(id, productDTO);
        if (product != null) {
            return ResponseEntity.ok(product);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id)
    {
        productService.deleteService(id);
        return ResponseEntity.noContent().build();
    }

}
