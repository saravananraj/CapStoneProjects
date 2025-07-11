package com.sara.ecommerce.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseClass {

    @Id
    private Long id;

    private Date createdAt = new Date();

    private Date lastUpdatedAt = new Date();

    private Status status;
}
