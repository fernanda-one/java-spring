package com.javaspring.models.repositories;

import com.javaspring.models.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Long> {
}
