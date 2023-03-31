package com.javaspring.models.repositories;

import com.javaspring.models.entities.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepo extends CrudRepository<Supplier, Long> {
}
