package com.myself.practicing.infrastructure.database;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import com.myself.practicing.domain.models.Product;

@Repository 
public class ProductMock {

    public final List<Product> products = new CopyOnWriteArrayList<>();

}
