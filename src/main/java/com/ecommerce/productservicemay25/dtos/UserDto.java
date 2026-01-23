package com.ecommerce.productservicemay25.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserDto {
    private Long id;
    private String name;
    private String email;
//    private List<Role> roles = new ArrayList<>();
}
