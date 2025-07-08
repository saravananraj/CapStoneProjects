package com.sara.ecommerce.tableInheritanceExample.singleTable;

import jakarta.persistence.Entity;

@Entity(name="st_mentor")
public class Mentor extends User {
    private Long hours;
}
