package com.sara.ecommerce.service;

import com.sara.ecommerce.clients.FakeStoreApiClient;
import com.sara.ecommerce.dao.Category;
import com.sara.ecommerce.dao.Product;
import com.sara.ecommerce.dto.FakeStoreProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements IProductService{

    @Autowired
    private FakeStoreApiClient fakeStoreApiClient;

    @Override
    public List<Product> getAllProducts() {
        List<FakeStoreProductDto> allFakeStoreProducts = fakeStoreApiClient.getAllFakeStoreProducts();
        List<Product> productDtos = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: allFakeStoreProducts) {
            productDtos.add(from(fakeStoreProductDto));
        }
        return productDtos;
    }

    @Override
    public Product getProductById(Long id) {
        FakeStoreProductDto fakeStoreProductById = fakeStoreApiClient.getFakeStoreProductById(id);
        return from(fakeStoreProductById);
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto = from(product);
        FakeStoreProductDto productOutput = fakeStoreApiClient.createProduct(fakeStoreProductDto);
        return from(productOutput);
    }

    public Product replaceProduct(Product input,Long id) {
        FakeStoreProductDto fakeStoreProductDtoInput = from(input);
        FakeStoreProductDto output = fakeStoreApiClient.replaceFakeStoreProduct(fakeStoreProductDtoInput,id);
        if(output==null) return null;
        return from(output);
    }

    @Override
    public void deleteProduct(Long id) {
        fakeStoreApiClient.deleteFakeStoreProduct(id);
    }

    private FakeStoreProductDto from(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getName());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImage(product.getImageUrl());
        if(product.getCategory() != null) {
            fakeStoreProductDto.setCategory(product.getCategory().getName());
        }
        return fakeStoreProductDto;
    }

    private Product from(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setName(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
}
