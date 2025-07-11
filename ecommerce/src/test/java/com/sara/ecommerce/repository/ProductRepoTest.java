package com.sara.ecommerce.repository;

import com.sara.ecommerce.dao.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductRepoTest {

    @Autowired
    ProductRepo productRepo;

    @Test
    public void queries() {
//        Optional<Product> output = productRepo.findById(1l);
//        System.out.println(output.get().getName());

//        List<Product> products = productRepo.findAll();
//        for (Product product : products) {
//            System.out.println(product.getName());
//        }

//        productRepo.deleteById(2l);
//
//        List<Product> products = productRepo.findAll();
//        for (Product product : products) {
//            System.out.println(product.getName());
//        }

//        List<Product> products = productRepo.getAllProducts();
//        for (Product product : products) {
//            System.out.println(product.getName());
//        }

//        Product productByIdByPosition = productRepo.getProductByIdByPosition(1l);
//        System.out.println("productByIdByPosition = " + productByIdByPosition.getName());
//
//        Product productByIdByNamed = productRepo.getProductByIdByName(3l);
//        System.out.println("productByIdByNamed = " + productByIdByNamed.getName());

        List<Product> products = productRepo.findProductByPriceBetween(260d, 280000d);
        for (Product product : products) {
            System.out.println(product.getName());
        }

    }

}