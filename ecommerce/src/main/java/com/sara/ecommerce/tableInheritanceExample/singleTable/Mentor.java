package com.sara.ecommerce.tableInheritanceExample.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="st_mentor")
@DiscriminatorValue(value = "10")
public class Mentor extends User {
    private Long hours;
}
