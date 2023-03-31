package com.javaspring.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter @Getter
public class CategoryDto {

    @NotEmpty(message = "name is required")
    private String name;
}
