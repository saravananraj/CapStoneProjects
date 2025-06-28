package com.sara.ecommerce.controller;

import com.sara.ecommerce.dto.ProductDto;
import com.sara.ecommerce.model.Category;
import com.sara.ecommerce.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
@Tag(name="Ecommerce management", description = "Ecommerce management application")
public class ProductController {

    private static List<ProductDto> productList = new ArrayList<>();

    @Autowired
    IProductService iProductService;

    @Operation(summary="get all products", description = "get all products in the productslist")
    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        return productList;
    }

    @Operation(summary="get product by id", description = "pass id to get product")
    @GetMapping("/products/{productId}")
    public ProductDto getProduct(@PathVariable("productId") Long productId) {
        if (!CollectionUtils.isEmpty(productList)) {
            for (ProductDto product : productList) {
                if (product.getProductId() == productId) {
                    return product;
                }
            }
        }
        return null;
    }

    @Operation(summary="create products", description = "create product by passing product")
    @PostMapping("products")
    public ProductDto createProduct(@RequestBody ProductDto product) {
        if (product != null) {
            productList.add(product);
        }
        return product;
    }

    @Operation(summary="update products", description = "update product by passing product")
    @PutMapping("/product/{id}")
    public ProductDto updateProduct(@RequestBody ProductDto product) {
        ProductDto updatedProduct = null;
        if (product != null) {
            updatedProduct = getProduct(product.productId);
            if (updatedProduct != null) {
                updatedProduct.setCategory(product.getCategory());
                updatedProduct.setProductName(product.getProductName());
                updatedProduct.setPrice(product.getPrice());
            }
        }
        return updatedProduct;
    }

    @Operation(summary="Delete product", description = "Delete the product by passing product id")
    @DeleteMapping("/products/{id}")
    public List<ProductDto> deleteProduct(@PathVariable("id") Long productId) {
        ProductDto updatedProduct = getProduct(productId);
        if (updatedProduct != null) {
            productList.remove(updatedProduct);
        }
        return productList;
    }

    static {
        ProductDto product1 = new ProductDto();
        product1.setProductName("Jeans");
        product1.setProductId(1L);
        product1.setPrice(1000L);
        Category category1 = new Category();
        category1.setDescription("Garments");
        category1.setName("Dress");
        product1.setCategory(category1);

        ProductDto product2 = new ProductDto();
        product2.setProductId(2L);
        product2.setProductName("Mouse");
        product2.setPrice(2000L);

        Category category2 = new Category();
        category2.setDescription("Garments");
        category2.setName("Dress");
        product2.setCategory(category2);

        productList.add(product1);
        productList.add(product2);
    }


}
