package com.javaspring.services;

import com.javaspring.models.entities.Product;
import com.javaspring.models.entities.Supplier;
import com.javaspring.models.repositories.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public Product save(Product product) {
        return productRepo.save(product);
    }

    public Product findOne(Long id){
        return productRepo.findById(id).get();
    }

    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }

    public void deleteOne(Long id){
        productRepo.deleteById(id);
    }

    public List<Product> findByName(String name){
        return productRepo.findByNameContains(name);
    }

    public void addSupplier(Supplier supplier, Long productId){
        Product product = findOne(productId);
        if (product == null){
            throw new RuntimeException("Product with ID"+productId+" Not found");
        }
        product.getSuppliers().add(supplier);
        save(product);
    }

    public List<Product> findByProductName(String name){
        return productRepo.findProductByName("%"+name+"%");
    }

    public List<Product> findByCategory(Long categoryId){
        return productRepo.findProductByCategory(categoryId);
    }
}
