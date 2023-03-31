package com.javaspring.services;

import com.javaspring.models.entities.Category;
import com.javaspring.models.repositories.CategoryRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public Category save(Category category){
        return categoryRepo.save(category);
    }

    public Iterable<Category> findAll(){
        return categoryRepo.findAll();
    }

    public Category findOne(Long id) {
        Optional<Category> category = categoryRepo.findById(id);
        if (!category.isPresent()){
            return null;
        }
        return category.get();
    }

    public void removeOne(Long id){
        categoryRepo.deleteById(id);
    }

}
