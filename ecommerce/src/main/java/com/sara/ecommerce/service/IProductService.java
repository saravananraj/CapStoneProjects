package com.sara.ecommerce.service;

import com.sara.ecommerce.model.Product;

import java.util.List;

public interface IProductService {

    public Product getProductById(Long id);

    public Product createProduct(Product product);

    public List<Product> getAllProducts();
}
