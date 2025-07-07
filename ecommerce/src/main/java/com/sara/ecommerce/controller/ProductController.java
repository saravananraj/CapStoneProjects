package com.sara.ecommerce.controller;

import com.sara.ecommerce.dao.Category;
import com.sara.ecommerce.dao.Product;
import com.sara.ecommerce.dto.CategoryDto;
import com.sara.ecommerce.dto.ProductDto;
import com.sara.ecommerce.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
@Tag(name="Ecommerce management", description = "Ecommerce management application")
public class ProductController {

    @Autowired
    IProductService productService;

    @Operation(summary="get all products", description = "get all products in the productslist")
    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        List<Product> allProducts = productService.getAllProducts();
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product : allProducts) {
            productDtos.add(from(product));
        }
        return productDtos;
    }

    @Operation(summary="get product by id", description = "pass id to get product")
    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") Long productId) {
        if (productId <= 0) {
            throw new IllegalArgumentException("Product Id not found");
        }
        Product product = productService.getProductById(productId);
        if (product == null) throw new NullPointerException("Product should not null");
        ProductDto productDto = from(product);
        return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
    }

    @Operation(summary="create products", description = "create product by passing product")
    @PostMapping("products")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        Product product = fromDto(productDto);
        Product output = productService.createProduct(product);
        if (output == null) throw new NullPointerException("Product should not null");
        return from(output);
    }

    @Operation(summary="update products", description = "update product by passing product")
    @PutMapping("/product/{id}")
    public ProductDto updateProduct(@PathVariable Long id,@RequestBody ProductDto productDto) {
        Product product = fromDto(productDto);
        Product output = productService.replaceProduct(product, id);
        if (output == null) throw new NullPointerException("Product should not null");
        return from(output);
    }

    @Operation(summary="Delete product", description = "Delete the product by passing product id")
    @DeleteMapping("/products/{id}")
    public ProductDto deleteProduct(@PathVariable("id") Long productId) {
        Product output = productService.deleteProduct(productId);
        return from(output);
    }

    private Product fromDto(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setDescription(productDto.getDescription());
        if(productDto.getCategory() != null) {
            Category category = new Category();
            category.setId(productDto.getCategory().getId());
            category.setName(productDto.getCategory().getName());
            product.setCategory(category);
        }
        return product;
    }

    private ProductDto from (Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        if (product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setId(product.getCategory().getId());
            categoryDto.setDescription(product.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }
        return productDto;
    }


}
