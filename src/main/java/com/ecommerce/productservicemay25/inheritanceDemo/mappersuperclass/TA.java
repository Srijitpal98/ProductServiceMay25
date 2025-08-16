package com.ecommerce.productservicemay25.inheritanceDemo.mappersuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TA extends User{
    private int numberOfHRs;
}
