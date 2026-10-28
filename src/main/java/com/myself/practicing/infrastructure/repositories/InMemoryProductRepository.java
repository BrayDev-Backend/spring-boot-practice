package com.myself.practicing.infrastructure.repositories;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;

import com.myself.practicing.domain.DTOs.ProductDTO;
import com.myself.practicing.domain.models.Product;
import com.myself.practicing.domain.repositories.ProductRepository;
import com.myself.practicing.infrastructure.database.ProductMock;

@Repository 
public class InMemoryProductRepository implements ProductRepository{

    private final ProductMock productMock;
    private final AtomicLong counterId = new AtomicLong();

    public InMemoryProductRepository(ProductMock productMock) {
        this.productMock = productMock;
    }

    @Override 
    public List<Product> findAllProducts()
    {
        return productMock.products;
    }

    @Override 
    public Product findProductById(Long id)
    {
        return productMock.products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override 
    public Product createProduct(ProductDTO product)
    {
        Product newProduct = new Product(
            counterId.incrementAndGet(),
            product.name(), 
            product.amount(), 
            product.category()
        );
        productMock.products.add(newProduct);
        return newProduct;
    }

    @Override 
    public Product updateProduct(Long id, ProductDTO product)
    {
        OptionalInt index = IntStream.range(0, productMock.products.size())
                .filter(i -> Objects.equals(productMock.products.get(i).getId(), id))
                .findFirst();

        if (index.isEmpty()) {
            return null;
        }

        Product updatedProduct = new Product(
            id,
            product.name(),
            product.amount(),
            product.category()
        );
        productMock.products.set(index.getAsInt(), updatedProduct);
        return updatedProduct;
    }

    public void deleteProduct(Long id)
    {
        OptionalInt index = IntStream.range(0, productMock.products.size())
                .filter(i -> Objects.equals(productMock.products.get(i).getId(), id))
                .findFirst();

        if (index.isEmpty())
        {
            throw new NoSuchElementException("No se encontró el producto con ID: " + id);
        }

        productMock.products.remove(index.getAsInt());
    }

}
