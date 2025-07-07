package com.sara.ecommerce.service;

import com.sara.ecommerce.dao.Product;
import com.sara.ecommerce.dto.ProductDto;

import java.util.List;

public interface IProductService {

    public Product getProductById(Long id);

    public Product createProduct(Product product);

    public Product replaceProduct(Product input,Long id);

    public Product deleteProduct(Long id);

    public List<Product> getAllProducts();
}
