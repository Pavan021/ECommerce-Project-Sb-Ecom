package com.ecommerce.project.services;

import com.ecommerce.project.models.Category;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private List<Category> categories = new ArrayList<>();
    private long nextId = 1L;

    @Override
    public List<Category> getCategories()
    {
        return categories;
    }

    @Override
    public String createCategories(Category category)
    {
        category.setCategoryId(nextId++);
        categories.add(category);
        return "Category added successfully!";
    }

    @Override
    public String deleteCategory(Long categoryId)
    {
//        Category category = categories.stream()
//                .filter(c-> c.getCategoryId().equals(categoryId))
//                .findFirst().get();

//        Category category = categories.stream()
//                .filter(c-> c.getCategoryId().equals(categoryId))
//                .findFirst().orElse(null);
//
//        if(category == null)
//        {
//            return "category not found";
//        }

        Category category = categories.stream()
                        .filter(c -> c.getCategoryId().equals(categoryId))
                                .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found"));
        categories.remove(category);
        return "Deleted Sucessfully";

    }

    @Override
    public Category updateCategory(Long categoryId, Category category)
    {
        Optional<Category> optionlCategory = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst();

        if(optionlCategory.isPresent()) {
            Category existingCategory = optionlCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            return existingCategory;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found");
        }
    }
}
