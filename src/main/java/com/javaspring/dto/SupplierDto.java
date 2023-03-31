package com.javaspring.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Setter @Getter
public class SupplierDto {
    @NotEmpty(message = "name is required")
    private String name;

    @NotEmpty(message = "address is required ")
    private String address;

    @NotEmpty(message = "email is required")
    @Email(message = "email is not valid")
    private String email;
}
