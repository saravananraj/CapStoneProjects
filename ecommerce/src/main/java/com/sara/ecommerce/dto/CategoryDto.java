package com.sara.ecommerce.dto;

import com.sara.ecommerce.dao.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {

    private Long id;

    private String name;

    private String description;

    private List<Product> products;

}
