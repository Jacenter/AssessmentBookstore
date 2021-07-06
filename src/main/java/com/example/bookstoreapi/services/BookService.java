package com.example.bookstoreapi.services;

import com.example.bookstoreapi.exceptions.ResourceNotFoundException;
import com.example.bookstoreapi.models.Book;
import com.example.bookstoreapi.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;


    //get all books
    public Iterable<Book> getAllBooks() {
        if (bookRepository.count() == 0) {
            logger.info("NO BOOKS EXIST");
            throw new ResourceNotFoundException("Error fetching books.");
        } else {
            logger.info("SUCCESSFULLY RETRIEVED ALL BOOKS");
            return bookRepository.findAll();
        }
    }

    //get all books from a category by category Id
    public Iterable<Book> getAllBooksByCategoryId(Long categoryId) {
        if (!(bookRepository.findAllByCategoryId(categoryId).iterator().hasNext())) {
            logger.info("NO BOOKS EXIST WITH CATEGORY ID " + categoryId);
            throw new ResourceNotFoundException("Error fetching books with category id");
        } else {
            logger.info("ALL BOOKS WITH CATEGORY ID OF " + categoryId + " SUCCESSFULLY RETRIEVED");
            return bookRepository.findAllByCategoryId(categoryId);
        }
    }

    public Iterable<Book> getAllBooksByCategoryName(String categoryName) {
        if (!(bookRepository.findAllByCategoryName(categoryName).iterator().hasNext())) {
            logger.info("NO BOOKS EXIST WITH CATEGORY NAME OF " + categoryName);
            throw new ResourceNotFoundException("Error fetching books with category name");
        } else {
            logger.info("ALL BOOKS WITH CATEGORY NAME " + categoryName + " SUCCESSFULLY RETRIEVED");
            return bookRepository.findAllByCategoryName(categoryName);
        }
    }

    //find books by name like
    public Iterable<Book> getAllBooksByNameContaining(String name) {
        if (!(bookRepository.findByNameContaining(name).iterator().hasNext())) {
            logger.info("NO BOOKS EXIST WITH A NAME LIKE OR CONTAINING : " + name);
            throw new ResourceNotFoundException("Error fetching books with name like or containing " + name);
        } else {
            logger.info("ALL BOOKS WITH NAME LIKE OR CONTAINING " + name + " SUCCESSFULLY RETRIEVED");
            return bookRepository.findByNameContaining(name);
        }
    }

    //get a specific book by id
    public Optional<Book> getBookById(Long id) {
        if (!(bookRepository.existsById(id))) {
            logger.info("NO BOOK EXISTS WITH ID OF " + id);
            throw new ResourceNotFoundException("Error fetching book with ID of " + id);
        } else {
            logger.info("BOOK WITH ID OF " + id + " SUCCESSFULLY RETRIEVED");
            return bookRepository.findById(id);
        }
    }

    //create a book
    public void createBook(Book book) {
        logger.info("BOOK SUCCESSFULLY CREATED");
        bookRepository.save(book);
    }

    //update a book
    public Book updateBook(Book book, Long id) {
        book.setId(id);
        logger.info("BOOK WITH ID OF " + id + " SUCCESSFULLY UPDATED");
        return bookRepository.save(book);
    }

    //delete a book
    public void deleteBookById(Long id) {
        logger.info("BOOK WITH ID OF " + id + " SUCCESSFULLY DELETED");
        bookRepository.deleteById(id);
    }
}
