package com.example.bookstoreapi.controllers;

import com.example.bookstoreapi.models.Book;
import com.example.bookstoreapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:54294")
@RestController
@RequestMapping(value = "/api/v1/bookstore")
public class BookController {

    @Autowired
    private BookService bookService;

    //get all books in bookstore
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

//    get all books from a certain category by category Id
    @GetMapping("/books/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Book> getAllBooksByCategoryId(@PathVariable("categoryId")Long categoryId) {
        return bookService.getAllBooksByCategoryId(categoryId);
    }

    //get all books from a certain category
    @GetMapping("/books/category/{categoryName}")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Book> getAllBooksByCategory(@PathVariable("categoryName")String categoryName) {
        return bookService.getAllBooksByCategoryName(categoryName);
    }

    //get all books with name containing
    @GetMapping("/books/names/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Book> getAllBooksByNameLike(@PathVariable("name")String name) {
        return bookService.getAllBooksByNameContaining(name);
    }

    //get a specific book by its ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Book> getBookById(@PathVariable("id")Long id) {
        return bookService.getBookById(id);
    }

    //get a book category by the book ID
    @GetMapping("/book/{id}/category")
    @ResponseStatus(HttpStatus.OK)
    public String getBookCategoryByBookId(@PathVariable("id")Long id) {
        return bookService.getBookById(id).get().getCategoryName();
    }

    //create a book
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@RequestBody Book book) {
        bookService.createBook(book);
    }

    //update a book
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@RequestBody Book book, @PathVariable("id") Long id) {
        bookService.updateBook(book,id);
    }

    //delete a book
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBookById(@PathVariable("id")Long id) {
        bookService.deleteBookById(id);
    }


}
