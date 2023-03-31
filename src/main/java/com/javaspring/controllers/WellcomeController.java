package com.javaspring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WellcomeController {

    @GetMapping
    public String wellcome(){
        return "wellcome to Spring Boot Rest APi";
    }

    @PostMapping
    public String order(){
        return "Data lain";
    }

}
