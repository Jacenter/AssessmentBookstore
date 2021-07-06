package com.example.bookstoreapi.services;

import com.example.bookstoreapi.exceptions.ResourceNotFoundException;
import com.example.bookstoreapi.models.Category;
import com.example.bookstoreapi.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private CategoryRepository categoryRepository;

    //get all categories
    public Iterable<Category> getAllCategories(){
        if(categoryRepository.count() == 0) {
            logger.info("NO CATEGORIES EXIST");
            throw new ResourceNotFoundException("Error fetching categories");
        }
        else {
            logger.info("SUCCESSFULLY RETRIEVED ALL CATEGORIES");
            return categoryRepository.findAll();
        }
    }

    //get a specific category by its name
    public Iterable<Category> getCategoryByName(String categoryName){
        return categoryRepository.findByCategoryName(categoryName);
    }

    //get a category by its ID
    public Optional<Category> getCategoryById(Long categoryId) {
        if (!(categoryRepository.existsById(categoryId))) {
            logger.info("NO CATEGORY EXISTS WITH ID OF " + categoryId);
            throw new ResourceNotFoundException("Error fetching category with ID of " + categoryId);
        } else {
            logger.info("SUCCESSFULLY RETRIEVED CATEGORY WITH ID OF " + categoryId);
            return categoryRepository.findById(categoryId);
        }
    }

    //create a category
    public void createCategory(Category category){
        logger.info("CATEGORY SUCCESSFULLY CREATED");
        categoryRepository.save(category);
    }

    //update a category
    public void updateCategory(Category category, Long categoryId) {
        category.setCategoryId(categoryId);
        logger.info("CATEGORY WITH ID OF " + categoryId + " SUCCESSFULLY UPDATED");
        categoryRepository.save(category);
    }

    //delete a category
    public void deleteCategory(Long categoryId) {
        logger.info("CATEGORY WITH ID OF " + categoryId + " SUCCESSFULLY DELETED");
        categoryRepository.deleteById(categoryId);
    }

}
