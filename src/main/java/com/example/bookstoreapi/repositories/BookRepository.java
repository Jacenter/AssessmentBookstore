package com.example.bookstoreapi.repositories;
import com.example.bookstoreapi.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends CrudRepository <Book, Long> {

    Iterable<Book> findAllByCategoryId(Long categoryId);

    Iterable<Book> findAllByCategoryName(String categoryName);

    Iterable<Book> findByNameContaining(String name);

}
