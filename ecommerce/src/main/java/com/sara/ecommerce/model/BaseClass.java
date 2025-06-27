package com.sara.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class BaseClass {

    private Long id;

    private Date createdAt;

    private Date lastUpdatedAt;

    private Status status;
}
