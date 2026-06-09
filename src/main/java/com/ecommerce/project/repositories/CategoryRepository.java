package com.ecommerce.project.repositories;

import com.ecommerce.project.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// Configures implementation at runtime to perform CRUD Operations on Category Table

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
