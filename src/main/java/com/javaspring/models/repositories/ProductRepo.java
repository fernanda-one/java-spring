package com.javaspring.models.repositories;

import com.javaspring.models.entities.Product;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long> {

    public List<Product> findByNameContains(String name);
    @Query("SELECT p FROM  Product p where p.name = :name")
    public List<Product> findProductByName(@PathParam("name") String name);

    @Query("SELECT Category FROM Product WHERE Category.id = :categoryID")
    public List<Product> findProductByCategory(Long categoryID);
}
