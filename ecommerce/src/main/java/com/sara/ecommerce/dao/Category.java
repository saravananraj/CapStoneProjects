package com.sara.ecommerce.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends  BaseClass {

    private String name;

    private String description;

    @OneToMany(fetch= FetchType.EAGER, mappedBy = "category")
    private List<Product> products;
}
