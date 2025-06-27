package com.sara.ecommerce.controller;

import com.sara.ecommerce.model.Category;
import com.sara.ecommerce.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        //Dummy Response
        Product product1 = new Product();
        product1.setProductName("Jeans");
        product1.setProductId(1L);
        product1.setPrice(1000L);
        Category category1 = new Category();
        category1.setDescription("Garments");
        category1.setName("Dress");
        product1.setCategory(category1);

        Product product2 = new Product();
        product2.setProductId(2L);
        product2.setProductName("Mouse");
        product2.setPrice(2000L);

        Category category2 = new Category();
        category2.setDescription("Garments");
        category2.setName("Dress");
        product2.setCategory(category2);


        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        return productList;
    }

    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable("productId") int productId) {
        //Dummy Response
        for (Product product : getAllProducts()) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

}
