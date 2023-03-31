package com.javaspring.dto;

import javax.validation.constraints.NotEmpty;

public class ProductDto {
    @NotEmpty(message = "name is required")
    private String name;
    @NotEmpty(message = "price is required")
    private double price;

    private String description;
}
