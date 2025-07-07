package com.sara.ecommerce.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseClass {

    private Date createdAt;

    private Date lastUpdatedAt;

    private Status status;
}
