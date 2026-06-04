package com.ecommerce.project.services;

import com.ecommerce.project.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    String createCategories(Category category);
    String deleteCategory(Long categoryId);
    Category updateCategory(Long categoryId, Category category);
}
