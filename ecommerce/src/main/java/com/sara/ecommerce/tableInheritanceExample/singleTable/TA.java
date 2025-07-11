package com.sara.ecommerce.tableInheritanceExample.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="st_ta")
@DiscriminatorValue(value = "7")
public class TA extends User {
    private Long ratings;
}
