package com.sara.ecommerce.dto;

import com.sara.ecommerce.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {
    private String name;

    private String description;

    private List<Product> products;

}
