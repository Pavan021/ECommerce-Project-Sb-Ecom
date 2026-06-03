package com.ecommerce.project.controller;

import com.ecommerce.project.models.Category;
import com.ecommerce.project.services.CategoryService;
import com.sun.source.tree.TryTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }

    @GetMapping("/api/public/categories")
    public List<Category> getCategories()
    {
        return categoryService.getCategories();
    }

    @PostMapping("/api/public/categories")
    public String createCategories(@RequestBody Category category)
    {
        return categoryService.createCategories(category);
    }

    @DeleteMapping("/api/public/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId)
    {
        try{
             String status = categoryService.deleteCategory(categoryId);
             return new ResponseEntity<>(status,HttpStatus.OK);
        }
        catch (ResponseStatusException ex)
        {
            return new ResponseEntity<>(ex.getReason(), HttpStatus.NOT_FOUND);
        }

    }
}
