package com.sara.ecommerce.service;

import com.sara.ecommerce.model.Product;

import java.util.List;

public class FakeStoreProductService implements IProductService{

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
