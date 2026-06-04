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
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }

    //@GetMapping("/public/categories")
    @RequestMapping(value = "/public/categories", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getCategories()
    {
        List<Category> categories = categoryService.getCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    public ResponseEntity<String> createCategories(@RequestBody Category category)
    {
        String createdStatus = categoryService.createCategories(category);
        return new ResponseEntity<>(createdStatus, HttpStatus.CREATED);
    }

    @DeleteMapping("/public/categories/{categoryId}")
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

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@PathVariable Long categoryId, @RequestBody Category category)
    {
        try{
            Category updatedCategory = categoryService.updateCategory(categoryId, category);
            return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
        }
        catch(ResponseStatusException ex) {
            return new ResponseEntity<>(ex.getReason(), ex.getStatusCode());
        }

    }
}
