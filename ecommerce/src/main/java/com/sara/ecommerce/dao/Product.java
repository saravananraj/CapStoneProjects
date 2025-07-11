package com.sara.ecommerce.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends  BaseClass {

    private String name;

    private String description;

    private Double price;

    private String imageUrl;

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private Category category;

    public Boolean isPrimeSpecificSale;


}
