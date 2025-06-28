package com.sara.ecommerce.dto;

import com.sara.ecommerce.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    public Long productId;
    public String productName;
    public Long price;
    public Category category;
}
