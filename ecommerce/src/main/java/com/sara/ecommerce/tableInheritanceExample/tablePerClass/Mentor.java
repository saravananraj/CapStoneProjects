package com.sara.ecommerce.tableInheritanceExample.tablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tc_mentor")
public class Mentor extends User {
    private Long hours;
}
