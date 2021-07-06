package com.example.bookstoreapi.repositories;

import com.example.bookstoreapi.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository <Category, Long> {

    Iterable<Category> findByCategoryName(String categoryName);
}
