package com.javaspring.controllers;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.javaspring.dto.ProductDto;
import com.javaspring.dto.ResponseData;
import com.javaspring.dto.SearchDto;
import com.javaspring.dto.SupplierDto;
import com.javaspring.models.entities.Product;
import com.javaspring.models.entities.Supplier;
import com.javaspring.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    ModelMapper modelMapper;
    @GetMapping
    public Iterable<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getOneById(@PathVariable("id") Long id){
        return productService.findOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Product>> update(@Valid @RequestBody Product product, Errors errors){
        ResponseData<Product> responseData = new ResponseData<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(productService.save(product));
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
    @PostMapping
    public ResponseEntity<ResponseData<Product>> create(@Valid @RequestBody ProductDto productDto, Errors errors){
        ResponseData<Product> responseData = new ResponseData<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        Product product = modelMapper.map(productDto, Product.class);
        responseData.setStatus(true);
        responseData.setPayload(productService.save(product));
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable("id") Long id){
        productService.deleteOne(id);
    }

    @PostMapping("/{id}")
    public void addSupplier(@PathVariable("id") @RequestBody Supplier supplier, Long productID){
        productService.addSupplier(supplier, productID);
    }

    @PostMapping("/search/product")
    public List<Product> getProductByName(@RequestBody SearchDto searchDto){
        return productService.findByProductName(searchDto.getSearchKey());
    }

    @GetMapping("/find-by-category/{id}")
    public List<Product> getProdukByCategory(@PathVariable("id") Long categoryID){
        return productService.findByCategory(categoryID);
    }
}

