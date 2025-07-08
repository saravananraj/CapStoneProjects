package com.sara.ecommerce.tableInheritanceExample.tablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tc_ta")
public class TA extends User {
    private Long ratings;
}
