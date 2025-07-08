package com.sara.ecommerce.tableInheritanceExample.singleTable;

import jakarta.persistence.Entity;

@Entity(name="st_ta")
public class TA extends User {
    private Long ratings;
}
