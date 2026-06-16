package com.ecommerce.productservicemay25.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel implements Serializable {
    private String title;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    @JsonBackReference
    private List<Product> products;
}
