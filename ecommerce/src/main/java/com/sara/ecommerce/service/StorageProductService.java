package com.sara.ecommerce.service;

import com.sara.ecommerce.dao.Product;
import com.sara.ecommerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("storageProductService")
@Primary
public class StorageProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepo.findById(id);
        return product.orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        Optional<Product> prodOutput = productRepo.findById(product.getId());
        if (prodOutput.isEmpty()) {
            return productRepo.save(product);
        }
        return prodOutput.get();
    }

    @Override
    public Product replaceProduct(Product product, Long productId) {
        product.setId(productId);
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        Optional<Product> output = productRepo.findById(productId);
        if (output.isPresent()) {
            productRepo.deleteById(productId);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}
