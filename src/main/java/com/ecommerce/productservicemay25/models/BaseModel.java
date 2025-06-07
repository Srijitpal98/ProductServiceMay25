package com.ecommerce.productservicemay25.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class BaseModel {
    private Long id;
    private Date created_at;
    private Date last_modified_at;
}
