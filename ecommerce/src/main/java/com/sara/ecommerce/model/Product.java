package com.sara.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    public Long productId;
    public String productName;
    public Long price;
    public Category category;


}
