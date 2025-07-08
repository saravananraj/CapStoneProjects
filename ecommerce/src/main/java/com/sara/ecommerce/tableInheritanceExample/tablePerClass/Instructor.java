package com.sara.ecommerce.tableInheritanceExample.tablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tc_instructor")
public class Instructor extends User {
    private String companyName;
}
