package com.ecommerce.project.services;

import com.ecommerce.project.models.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private List<Category> categories = new ArrayList<>();

    public List<Category> getCategories()
    {
        return categories;
    }

    public String createCategories(@RequestBody Category category)
    {
        categories.add(category);
        return "Category added successfully!";
    }
}
