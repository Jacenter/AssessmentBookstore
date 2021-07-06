package com.example.bookstoreapi.controllers;

import com.example.bookstoreapi.models.Category;
import com.example.bookstoreapi.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:54294")
@RestController
@RequestMapping(value = "/api/v1/bookstore/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //get all categories
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    //get a category by its ID
    @GetMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Category> getCategoryById(@PathVariable("categoryId") Long categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    //get a category by its name
//    @GetMapping("/{categoryName}")
//    @ResponseStatus(HttpStatus.OK)
//    public Iterable<Category> getCategoryByName(@PathVariable("categoryName")String categoryName) {
//        return categoryService.getCategoryByName(categoryName);
//    }

    //create a category
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
    }

    //update a category
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCategory(@RequestBody Category category, @PathVariable("id") Long categoryId) {
        categoryService.updateCategory(category,categoryId);
    }

    //delete a category
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable("id") Long categoryId) {
        categoryService.getCategoryById(categoryId);
    }
}
